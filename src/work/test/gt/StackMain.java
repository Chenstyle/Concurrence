package work.test.gt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        File file = new File("D:\\360极速浏览器下载\\计算机科学概论 原书第3版 .pdf");
        System.out.println(System.currentTimeMillis());
        System.out.println(countFileMD5(file));
        System.out.println(System.currentTimeMillis());
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
