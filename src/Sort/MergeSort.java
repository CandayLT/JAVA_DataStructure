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
        int leftPos = left, rightPos = center + 1;

        int tPos;
        for (tPos = 0; leftPos <= center && rightPos <= right; tPos++) {
            if (input[leftPos] < input[rightPos])
                temp[tPos] = input[leftPos++];
            else
                temp[tPos] = input[rightPos++];
        }

        while (leftPos <= center)
            temp[tPos++] = input[leftPos++];

        while (rightPos <= right)
            temp[tPos++] = input[rightPos++];

        for (tPos = 0; left <= right; left++, tPos++)
            input[left] = input[tPos];
    }
}