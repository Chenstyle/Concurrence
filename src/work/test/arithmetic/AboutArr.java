package work.test.arithmetic;

import java.util.Random;

/**
 * @author Chenstyle
 *         2016/11/21 0021
 */
public class AboutArr {

    public int[] initArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int[] exchangeArr(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int ranPosition = random.nextInt(arr.length);
            int temp = arr[ranPosition];
            arr[ranPosition] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    /**
     *  对 100 个数字进行排序
     * @param arr2 需要排序的对象
     * @return 排序完成的序列
     */
    private int[] sortArr(int[] arr2) {
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                if (arr2[i] > arr2[j]) {
                    int temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        return arr2;
    }
}
