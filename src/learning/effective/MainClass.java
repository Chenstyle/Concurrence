package learning.effective;

import work.test.StrUtil;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static void main(String[] args) {
        long money = 123456789098765L;
        String comm = StrUtil.lotteryBeanFormat(money);
        String clearNum = StrUtil.removeCommaOfNumber(comm);
        System.out.println(clearNum);
    }
}
