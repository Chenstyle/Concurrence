package learning.effective;

import work.test.arithmetic.AboutArr;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static void main(String[] args) {
        AboutArr aboutArr = new AboutArr();
        int[] arr = aboutArr.initArr(100);
        aboutArr.printArr(arr);
        int[] arr2 = aboutArr.exchangeArr(arr);
        aboutArr.printArr(arr2);



        aboutArr.printArr(arr2);
    }
}
