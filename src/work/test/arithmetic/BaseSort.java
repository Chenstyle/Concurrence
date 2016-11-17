package work.test.arithmetic;

/**
 * @author Chenstyle
 *         2016/11/17 0017
 */
public class BaseSort {

    public static int[] sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[i] > unsorted[j]) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
        return unsorted;
    }
}