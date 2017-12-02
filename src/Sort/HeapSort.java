package Sort;

/**
 * Name : 堆排序
 * Heap kind : maxHeap
 * Created by TangChen on 17/11/27.
 */
public class HeapSort {
    public static void sort(Integer[] input) {
        int elementNum = input.length;

        for (int i = elementNum / 2; i >= 0; i--)
            down(input, i, elementNum); //构造一个maxHeap

        for (int limit = elementNum - 1; limit > 0; limit--)
            deleteMax(input, limit);
    }

    public static void down(Integer[] input, int p, int limit) {
        int child;
        for (; 2 * p + 1 < limit; p = child) {
            child = 2 * p + 1;
            if (child + 1 != limit && input[child] < input[child + 1])
                child++;

            if (input[p] < input[child])
                swap(input, p, child);
            else
                break;
        }
    }

    public static void deleteMax(Integer[] input, int limit) {
        swap(input, 0, limit);
        down(input, 0, --limit);
    }

    private static void swap(Integer[] input, int i, int limit) {
        int maxTemp = input[i];
        input[i] = input[limit];
        input[limit] = maxTemp;
    }
}