package work.test.gt;

import java.util.ArrayList;

/**
 * @author Chenstyle
 *         2017-5-12
 */
public class TestList {

    private final ArrayList<String> mList = new ArrayList<>();

    public void addList(String list) {
        mList.add(list);
    }



    /**
     * 格式化条形码，格式为4-4-4-7。前面三个4位，后面一股脑出来
     *
     * @param number 条形码数字号
     * @return 格式化的银行卡卡号
     */
   public static String formatBaNum(String number) {
       int len = number.length();
       if (len > 12) {
           String numBefore = number.substring(0, 12);
           String numAfter = number.substring(12, len);
           return cutFour(numBefore)  + numAfter;
       } else {
           // 不大于12位的时候，直接出4个切割方式
           return cutFour(number);
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
        int index;
        for (int i = 0; i < groupNum * 4; i += 4) {
            index = i + 4;
            four = formatStr.substring(i, index);
            result = result + " " + four;
        }
        result = result + " " + formatStr.substring(groupNum * 4, len);

        return result.substring(1, result.length());
    }
}
