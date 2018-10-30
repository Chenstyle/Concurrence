package work.test.gt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Chenstyle
 *         2017-6-9
 */
public class StackMain {
    private static final String TAG = "StackMain";

    static String TEST = "teat";

    static {
        String TAG = "Call";
    }

    public static void main(String[] args) throws IOException {
        int[] nums = {0, 0, 0, 0, 0};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if (0 == nums[i] + nums[j] + nums[z]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[z]);
                        resultList.add(list);
                    }
                }
            }
        }
        int removeIndex = 0;
        for (int i = 0; i < resultList.size(); i++) {
            for (List<Integer> list : resultList) {
                if (resultList.get(i).equals(list)) {
                    removeIndex = i;
                }
            }
        }
        if (removeIndex != 0) {
            resultList.remove(removeIndex);
        }

        return resultList;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (target == nums[i] + nums[j]) {
                    num1 = j;
                    num2 = i;
                    break;
                }
            }
        }

        return new int[]{num1, num2};
    }

    public static String randomUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    /**
     * 生成64位UUID
     *
     * @return
     */
    public static String generateUUID64() {
        return (randomUUID() + randomUUID());
    }

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    private static int[] twoSum(int[] nums, int target) {
        int sum0 = 0, sum1 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (target == nums[i] + nums[i1]) {
                    sum0 = i;
                    sum1 = i1;
                    break;
                }

            }

        }

        return new int[]{sum0, sum1};
    }

    /**
     * 将分为单位的金额转换为元，并格式化数字
     *
     * @param centMoney 以分为单位的金额
     * @return XX.XX 格式，以元为单位的金额
     */

    public static String centToBunk(String centMoney) {
        try {

            BigDecimal x1 = BigDecimal.valueOf(Float.parseFloat(centMoney));
            BigDecimal x2 = BigDecimal.valueOf(100.0f);
            return String.format(Locale.getDefault(), "%.2f", x1.divide(x2));

        } catch (Exception e) {
            e.printStackTrace();

        }

        return "0.00";
    }


    /**
     * 对小数保留多位四舍五入，在整数后面增加多位0作为后缀
     *
     * @param number  需要转换的数字 多为单位为元的金额
     * @param decimal 在此单位后添加0的个数
     * @return 返回 X.xx 格式的字符串
     */
    public static String round(String number, int decimal) {
        double double1 = Double.parseDouble(number);
        BigDecimal setScale = new BigDecimal(double1).setScale(decimal, RoundingMode.HALF_UP);
        return String.valueOf(setScale);
    }

    /**
     * 计算文件 MD5 值以供校验
     *
     * @param file 需要计算的文件
     * @return 该文件的MD5
     * @throws IOException 操作文件会抛出的异常
     */
    private static String countFileMD5(final File file) throws IOException {
        //Get file input stream for reading the file content
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("md5");
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        final FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        final byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while (-1 != (bytesCount = fis.read(byteArray))) {
            digest.update(byteArray, 0, bytesCount);
        }

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        final byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        final StringBuilder sb = new StringBuilder();
        for (final byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }

    /**
     * 获取单个文件的MD5值！
     *
     * @param file
     * @return
     */
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    private static String getUrl(String content) {
        int start = content.indexOf("http");
        int end = content.indexOf("领取") - 1;
        return content.substring(start, end);
    }

    private static String addArgumentForUrl(String content, String argument) {
        int start = content.indexOf("http");
        int end = content.indexOf("领取") - 1;
        String addUrl = content.substring(start, end) + argument;


        return content.substring(0, start) + addUrl + content.substring(end, content.length());
    }

    /**
     * 生成文件的MD5值
     *
     * @param f 需要检验的文件
     * @return md5
     */
    private static String checkMd5(File f) {

        FileInputStream fis = null;
        byte[] rb = null;
        DigestInputStream digestInputStream = null;
        try {
            fis = new FileInputStream(f);
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digestInputStream = new DigestInputStream(fis,
                    md5);
            byte[] buffer = new byte[4096];
            while (digestInputStream.read(buffer) > 0) ;
            md5 = digestInputStream.getMessageDigest();
            rb = md5.digest();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (byte aRb : rb) {
            String a = Integer.toHexString(0XFF & aRb);
            if (a.length() < 2) {
                a = '0' + a;
            }
            sb.append(a);
        }
        return sb.toString();
    }

    private static String clipOilCode(String code) {
        return code.substring(0, 4) + " " + code.substring(4, code.length());
    }

    public static int timeToMonth(long time) {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("MM", Locale.getDefault());
        String dateDay = format.format(date);
        return Integer.parseInt(dateDay);
    }

    /**
     * 获取这一天是这个月的第几天
     *
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
