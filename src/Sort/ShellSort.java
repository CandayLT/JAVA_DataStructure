package Sort;

/**
 * Name : 希尔排序
 * Created by TangChen on 17/11/27.
 */
public class ShellSort {
    public static void sort(Integer[] input) {
        int increment, i, j, tmp;
        int n = input.length;

        for (increment = n / 2; increment >= 1; increment /= 2) {
            for (i = 1; i + increment < n; i++) {
                tmp = input[i];

                for (j = i; j - increment >= 0 && input[j - increment] > tmp; j -= increment) {
                    input[j] = input[j - increment];
                }

                input[j] = tmp;
            }
        }

    }
}