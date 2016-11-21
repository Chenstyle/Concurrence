package work.test;

/**
 * @author Chenstyle
 * @date 2016/10/24 0024
 * @time 9:43
 */
public class StrUtil {

    /**
     * 插入逗号到数字之中，只支持两位小数或没有小数
     *
     * @param amount 数字字符串
     * @return 分割后的数字字符串
     */
    public static String insertCommaToNumber(String amount) {
        // 判断空和边界值
        if (null == amount || "".equals(amount)) {
            return "";
        }
        // 是否是浮点数
        boolean isFloat = false;
        String floatLater = "";
        if (amount.length() > 3) {
            if (amount.charAt(amount.length() - 3) == '.') {
                isFloat = true;
                floatLater = amount.substring(amount.length() - 3, amount.length());
                amount = amount.substring(0, amount.length() - 3);
            }
        }

        // 判断非数字字符串或者非2位小数点
        try {
            long number = Long.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new NullPointerException("Parameter not number or decimals not 2");
        }

        // 判断是否是负数。下方只要纯数字
        boolean isMinus;
        String amString;
        if (amount.charAt(0) == '-') {
            isMinus = true;
            amString = amount.substring(1);
        } else {
            isMinus = false;
            amString = amount;
        }
        StringBuilder resultBuilder = new StringBuilder();

        if (amString.length() <= 3) {
            resultBuilder.append(amString);
        } else {
            // 分割字符串
            for (int i = 1; i <= amString.length(); i++) {
                if ((i - 1) % 3 == 0 && i != 1) {
                    resultBuilder.append(",");
                }
                resultBuilder.append(amString.substring(amString.length() - i, amString.length() - i + 1));
            }
            resultBuilder.reverse();
        }

        String result = resultBuilder.toString();
        if (isFloat) {
            result = result + floatLater;
        }
        if (isMinus) {
            result = "-" + result;
        }

        return result;
    }

    /**
     * 消除金额字符中的逗号
     *
     * @param commaNumber 含有逗号的金额字符串
     * @return 不含逗号的金额字符串
     */
    public static String removeCommaOfNumber(String commaNumber) {
        if (commaNumber.length() > 4) {
            char[] commaArr = commaNumber.toCharArray();
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < commaNumber.length(); i++) {
                if (commaArr[i] != ',') {
                    num.append(commaArr[i]);
                }
            }
            return num.toString();
        } else {
            return commaNumber;
        }
    }

    /**
     * 彩豆的显示规则（数字部分包括小数点最多显示4个长度）
     *（1）0--9999以下直接显示
     *（2）1万-9999万显示：x.xx万、xx.x万、xxx万、xxxx万；
     *（3）1亿以上显示：x.xx亿、xx.x亿、xxx亿、xxxx亿+
     */
    /**
     * 金额格式格式化彩豆
     *
     * @param value 需要格式化的值 如：1234
     * @return 格式化后的字符串 如："1,234"
     */
    public static String lotteryBeanFormat(long value) {
        return lotteryBeanFormat(String.valueOf(value));
    }

    /**
     * 金额格式格式化彩豆
     *
     * @param lotteryBean 字符串类型的要格式化的数字："1234"
     * @return 格式化后的格式："1,234"
     */
    public static String lotteryBeanFormat(String lotteryBean) {

        int numberLen = lotteryBean.length();
        if (numberLen <= 4) {
            // 四位数字。最大9,999 不足一万
            return insertCommaToNumber(lotteryBean);
        } else if (4 < numberLen && numberLen <= 8) {
            // 8位数字。最多99,999,999 不足一亿
            return insertCommaToNumber(lotteryBean.substring(0, numberLen - 4)) + "万";
        } else {
            // 上亿的情况
            return insertCommaToNumber(lotteryBean.substring(0, numberLen - 8)) + "亿";
        }
    }

    /**
     * 姓名中插入*号
     *
     * @param name 姓名："王大锤"
     * @return 插入*号："王*锤"
     */
    public static String nameMiddleStart(String name) {
        if (name.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder(name);
        String result;
        switch (name.length()) {
            case 1:
                return name;
            case 2:
                result = sb.replace(1, name.length(), "*").toString();
                return result;
            default:
                StringBuilder star = new StringBuilder();
                for (int i = 0; i < name.length() - 2; i++) {
                    star.append("*");
                }
                result = sb.replace(1, name.length() - 1, star.toString()).toString();
                return result;
        }
    }

    /**
     * 中间插入 * 号
     *
     * @param name   要改变的字符串
     * @param before 字符串前保留位数
     * @param after  字符串后保留位数
     * @return 格式化后的字符串
     */
    public static String middleStart(String name, int before, int after) {
        StringBuilder sb = new StringBuilder(name);
        String result;

        switch (name.length()) {
            case 1:
                // 如果只有一个字符，直接返回
                return name;
            case 2:
                // 如果有两个字符，替换后面一个字
                result = sb.replace(1, name.length(), "*").toString();
                return result;
            default:
                // 如果大于2个字符，替换中间的字符为星号
                StringBuilder star = new StringBuilder();
                for (int i = 0; i < name.length() - before - after; i++) {
                    star.append("*");
                }
                result = sb.replace(before, name.length() - after, star.toString()).toString();
                return result;
        }
    }

    /**
     * 统计一个字符串出现了几次
     *
     * @param content 需要统计的字符串
     * @param target  目标字符
     * @return 出现次数
     */
    public static int appearTimes(String content, String target) {
        int cLen = content.length();
        int tLen = target.length();
        int times = 0;
        if (tLen > cLen) {
            return times;
        }
        if (tLen == cLen) {
            return 1;
        }
        for (int i = 0; i < cLen; i++) {
            if (tLen + i < cLen) {
                if (target.equals(content.substring(i, tLen + i))) {
                    times++;
                }
            }
        }

        return times;
    }
}
