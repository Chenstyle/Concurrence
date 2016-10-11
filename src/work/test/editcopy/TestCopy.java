package work.test.editcopy;

/**
 * Created by Chenstyle on 2016/9/27 0027.
 */
public class TestCopy {
    public static final String CODE = "6756214263451223";
    public static final String CODE_LONG = "6756214263451223321";
    public static final String CODE_CUT = "6756 2142 63451223";
    public static final String CODE_SHORT = "67562142634512";

    public static String usingCode(String sCode) {
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
