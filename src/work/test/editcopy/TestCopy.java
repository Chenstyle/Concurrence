package work.test.editcopy;

/**
 * Created by Chenstyle on 2016/9/27 0027.
 */
public class TestCopy {
    private static final String CODE = "6756214263451223";
    private static final String CODE_LONG = "6756214263451223321";
    private static final String CODE_CUT = "6756 2142 63451223";
    private static final String CODE_SHORT = "67562142634512";

    /**
     * 去除字符串中的空格，并按4个一组隔开
     * @param sCode 需要处理的字符串
     * @return 按4个字符一组隔开的字符串
     */
    private static String usingCode(String sCode) {
        if (sCode.length() < 19) {
            String s = sCode.replace(" ", "");
            char[] arrCode = s.toCharArray();
            int arrLen = arrCode.length;
            if (arrCode[arrLen % 5] != ' ') {
                return s.replaceAll("(.{4})", "$1 ");
            } else {
                return s;
            }
        } else {
            return sCode;
        }
    }

    public static void main(String[] args) {
        String s = usingCode(CODE);
        System.out.println(s);
    }
}
