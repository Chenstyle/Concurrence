package work.test.gt;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Chenstyle
 *         2017-5-31
 */
public class CalendarMain {

    public static void main(String[] args) {

        int diff = calculateDaysDiff("2016-6-6");
        System.out.println(diff);
    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 求一个月的天数
     *
     * @param date 日期字符串
     * @return 这个月的天数
     */
    public static int getMouthDays(String date) {

        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);

        Map<Integer, Integer> monthDays = new HashMap<>();
        monthDays.put(1, 31);
        monthDays.put(2, 28);
        monthDays.put(3, 31);
        monthDays.put(4, 30);
        monthDays.put(5, 31);
        monthDays.put(6, 30);
        monthDays.put(7, 31);
        monthDays.put(8, 31);
        monthDays.put(9, 30);
        monthDays.put(10, 31);
        monthDays.put(11, 30);
        monthDays.put(12, 31);
        int monthDay = monthDays.get(month);
        if (month == 2) {
            if (isLeapYear(year)) {
                monthDay = monthDay + 1;
            }
        }

        return monthDay;
    }

    /**
     * @param year 年份
     * @return 是否是闰年
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * 使用蔡勒公式计算这个月的第一天是星期几
     *
     * @param date 日期，格式：yyyy-mm-dd
     * @return 星期数，0为星期一，6为星期天
     */
    public static int calculateWeekDay(String date) {
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = 1;

        if (month == 1) {
            month = 13;
            year = year - 1;
        }

        if (month == 2) {
            month = 14;
            year = year - 1;
        }
        return (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
    }

    /**
     * 计算月份差值
     *
     * @param originalDate 原日期，格式：yyyy-MM-dd
     * @param nowDate      现在的日期，格式：yyyy-MM-dd
     * @return 两个日期之间月份的差值
     */
    private static int calculateMonth(String originalDate, String nowDate) {
        String[] oriArr = originalDate.split("-");
        String[] nowArr = nowDate.split("-");
        int nowYear = Integer.parseInt(nowArr[0]);
        int nowMonth = Integer.parseInt(nowArr[1]);
        int oriYear = Integer.parseInt(oriArr[0]);
        int oriMonth = Integer.parseInt(oriArr[1]);

        return (nowYear - oriYear) * 12 + nowMonth - oriMonth;
    }

    /**
     * 计算日期和现在的差值
     *
     * @param showDate 显示日期 格式：yyyy-MM-dd
     * @return
     */
    private static int calculateDaysDiff(String showDate) {
        String nowDate = getDate();
        int nowYear = Integer.parseInt(nowDate.split("-")[0]);
        int nowMonth = Integer.parseInt(nowDate.split("-")[1]);
        int nowDay = Integer.parseInt(nowDate.split("-")[2]);

        int showYear = Integer.parseInt(showDate.split("-")[0]);
        int showMonth = Integer.parseInt(showDate.split("-")[1]);
        int showDay = Integer.parseInt(showDate.split("-")[2]);

        Date dateNow = new GregorianCalendar(nowYear, nowMonth, nowDay, 0, 0, 0).getTime();
        Date dateShow = new GregorianCalendar(showYear, showMonth, showDay, 0, 0, 0).getTime();

        long day2 = dateNow.getTime();
        long day1 = dateShow.getTime();

        int diff = (int) ((day2 - day1) / (24 * 60 * 60 * 1000));

        return Math.abs(diff);
    }
}
