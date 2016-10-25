package work.test;

import java.math.BigDecimal;

/**
 * @author Chenstyle
 * @date 2016/10/24 0024
 * @time 9:43
 */
public class StrUtil {

    /**
     *  插入逗号到数字之中，只支持两位小数或没有小数
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

//    /**
//     *  消除金额字符中的逗号
//     * @param commaNumber 含有逗号的金额字符串
//     * @return 不含逗号的金额字符串
//     */
//    public static String removeCommaOfNumber(String commaNumber) {
//        if (commaNumber.length() > 4) {
//            if (commaNumber.charAt(commaNumber.length() - 4) != ',') {
//                return commaNumber;
//            } else {
//                char[] commaArr = commaNumber.toCharArray();
//                for (int i = 0; i < commaNumber.length(); i++) {
//
//                }
//                return "";
//            }
//        } else {
//            return commaNumber;
//        }
//    }


}
