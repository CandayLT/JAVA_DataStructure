package Sort;

/**
 * Created by TangChen on 17/11/29.
 */
public class QuickSort {
    public static void sort(Integer[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static int getPivot(Integer[] input, int left, int right) {
        int center = (left + right) / 2;

        if (input[left] > input[center])
            swap(input, left, center);

        if (input[left] > input[right])
            swap(input, left, right);

        if (input[center] > input[right])
            swap(input, center, right);

        swap(input, center, right - 1);
        return input[right - 1];
    }

    public static void quickSort(Integer[] input, int left, int right) {
        if (left < right) {
            int pivot = getPivot(input, left, right);
            int i = left, j = right - 1;

            for(; ;) {
                while (input[++i] < pivot);
                while (input[--j] > pivot);

                if (i < j)
                    swap(input, i, j);
                else break;
            }

            swap(input, i, right - 1);
            quickSort(input, left, i - 1);
            quickSort(input, i + 1, right);
        }
    }

    private static void swap(Integer[] input, int swap1, int swap2) {
        int temp = input[swap1];
        input[swap1] = input[swap2];
        input[swap2] = temp;
    }
}