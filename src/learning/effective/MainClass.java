package learning.effective;

import work.test.StrUtil;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static void main(String[] args) {
        double d = 88888888.44;

        System.out.println(d);

        float d1 = (float)d;

        System.out.println(d1);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String strMon = currencyFormat.format(d).toString();
        System.out.println(strMon);
        strMon = strMon.substring(1, strMon.length());
        System.out.println(strMon);
    }

}
