package Sort;

/**
 * Name : 插入排序
 * Created by TangChen on 17/11/27.
 */
public class InsertionSort {
    public static void sort(Integer[] input) {
        int i, j, tmp;
        int n = input.length;
        for(i = 1; i < n; i++) {
            tmp = input[i];

            for(j = i; j > 0 && input[j - 1] > tmp; j--) {
                input[j] = input[j - 1];
            }

            input[j] = tmp;
        }
    }
}