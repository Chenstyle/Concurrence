package learning.effective;

import work.test.arithmetic.BaseSort;

/**
 * @author Chenstyle
 * @date 2016/10/20 0020
 * @time 14:15
 */
public class MainClass {

    public static void main(String[] args) {
        int[] iArr = {1, 5, 4, 2, 3};
        BaseSort.sort(iArr);
        for (int i : iArr) {
            System.out.println(i);
        }
    }
}
