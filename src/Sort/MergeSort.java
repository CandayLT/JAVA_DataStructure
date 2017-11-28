package Sort;

/**
 * Name : 归并排序
 * Created by TangChen on 17/11/28.
 */
public class MergeSort {
    public static void sort(Integer[] input) {
        int limit = input.length;
        Integer[] temp = new Integer[limit];

        mergeSort(input, temp, 0, limit - 1);
    }

    public static void mergeSort(Integer[] input, Integer[] temp, int left, int right) {

        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(input, temp, left, center);
            mergeSort(input, temp, center + 1, right);
            merge(input, temp, left, center, right);
        }
    }

    //merge的思想是分治中的"治"，即将两个排序好的有序数组input[left - center]和input[center + 1 - right]合并
    private static void merge(Integer[] input, Integer[] temp, int left, int center, int right) {
        int leftArrayPos = left, rightArrayPos = center + 1;
        int tPos;

        //归并两个数组
        for (tPos = 0; leftArrayPos <= center && rightArrayPos <= right; tPos++) {
            if (input[leftArrayPos] <= input[rightArrayPos])
                temp[tPos] = input[leftArrayPos++];
            else
                temp[tPos] = input[rightArrayPos++];
        }

        while (leftArrayPos <= center)
            temp[tPos++] = input[leftArrayPos++];

        while (rightArrayPos <= right)
            temp[tPos++] = input[rightArrayPos++];

        tPos = 0;
        while (left <= right)
            input[left++] = temp[tPos++];
    }
}