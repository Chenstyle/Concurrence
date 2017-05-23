package work.test.lottery;

import com.sun.deploy.util.StringUtils;

/**
 * @author Chenstyle
 *         2017/2/22 0022
 */
public class CutBall {

    private static String url = "http://b.guotongshiyou.com?s=3456835756543&c=4040001234";
    private static String url2 = "http://b.guotongshiyou.com?s=3456+35756543&c=4040001234";

    private static String mCardNo = "130009639062578314";
    private static String place = "  ";

    public static void main(String[] args) {

        String cardNo = "6228480478327299473";

        System.out.println(formatCardNo("6223455676746768"));
    }

    public static String[] getInfo(String url) {

        String smartCardNo = null;
        String eCardNo = null;
        if (url.contains("http://b.guotongshiyou.com")) {
            int index1 = url.indexOf("?s=");
            int index2 = url.indexOf("&c=");
            smartCardNo = url.substring(index1 + 3, index2);
            eCardNo = url.substring(index2 + 3, url.length());
            if (smartCardNo.matches("[0-9]+") && eCardNo.matches("[0-9]+")) {
                return new String[]{smartCardNo, eCardNo};
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private String cutCardNo(String formatNum) {
        return formatNum.substring(0, 4) + place + formatNum.substring(4, 8) +
                place + formatNum.substring(8, 12) + place + formatNum.substring(12, formatNum.length());
    }

    /**
     * 格式化银行卡卡号 中间加空格隔开，数字个数 6-5-4-4...
     *
     * @param cardNo 银行卡卡号
     * @return 格式化的银行卡卡号
     */
    public static String formatCardNo(String cardNo) {
        // 需要添加的空格
        String place = " ";

        // 先判断长度
        int cardLength = cardNo.length();
        // 将长度切成6-5-4-4的格式
        if (cardLength <= 11) {
            // 格式为 6-5
            return cardNo.substring(0, 6) + place + cardNo.substring(6, cardLength);
        } else {
            // 大于11，只需计算后面有几个4
            String headNum = cardNo.substring(0, 6) + place + cardNo.substring(6, 11);
            String lostNum = cardNo.substring(11, cardLength);
            return headNum  + cutFour(lostNum);
        }
    }

    /**
     * 把字符串切割成按四位分割，中间用空格填充的方式
     * @param formatStr 需要切割的字符串
     * @return 四位切割，空格隔开
     */
    private static String cutFour(String formatStr) {
        int len = formatStr.length();
        int groupNum = len / 4;
        String result = "";
        String four = "";
        int index = 0;
        for (int i = 0; i < groupNum * 4; i += 4) {
            index = i + 4;
            four = formatStr.substring(i, index);
            result = result + " " + four;
        }
        result = result + " " + formatStr.substring(groupNum * 4, len);

        return result;
    }
}
