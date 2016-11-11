package learning.effective;

import work.test.StrUtil;
import work.test.bean.LabList;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass<T> {

    public static void main(String[] args) {
        String hge = "12031251421";

        System.out.println(StrUtil.middleStart(hge, 3, 4));
    }

    private static void printS(String ...strings) {
        for (String sh : strings) {
            System.out.println(sh);
        }
    }


}
