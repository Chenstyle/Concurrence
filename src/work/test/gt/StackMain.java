package work.test.gt;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Chenstyle
 *         2017-6-9
 */
public class StackMain {

    static String TEST = "teat";

    static {
        String TAG = "Call";
    }

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item = " + i);
        }

        int stackSize = list.size();
        int resultSize = stackSize - 3;
        for (int i = stackSize - 1; i > resultSize - 1; i--) {
            list.remove(i);
        }

        System.out.println(list.size());*/

        System.out.println(getDayOfMonth());
    }

    public static int timeToMonth(long time) {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("MM", Locale.getDefault());
        String dateDay =  format.format(date);
        return Integer.parseInt(dateDay);
    }

    /**
     * 获取这一天是这个月的第几天
     * @return 当前时间是本月的第几天
     */
    public static int getDayOfMonth() {
        long time = new Date().getTime();
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        String dayOfMonth = simpleDateFormat.format(date);
        return Integer.parseInt(dayOfMonth);
    }
}
