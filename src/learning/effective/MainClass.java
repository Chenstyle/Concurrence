package learning.effective;

import learning.thinking.design.Singleton;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static String changeTimeStyle(String time) {
        String[] split = time.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]).append("年");
        if (split[1].length() == 1) {
            sb.append("0").append(split[1]).append("月");
        } else {
            sb.append(split[1]).append("月");
        }
        return sb.toString();
    }

    public static void main(String args[]) {

        System.out.println(sum(1, 2, 3));

    }

    public static int sum(int ...params) {
        int sum = 0;
        for (int i : params) {
            sum += i;
        }
        return sum;
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().equals("") || str.trim().equalsIgnoreCase("null");
    }
}
