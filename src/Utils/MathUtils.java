package Utils;

/**
 * Created by TangChen on 17/11/13.
 */
public class MathUtils {

    /**
     * 返回不小于某个整数的素数
     * @param num 整数
     * @return 下一个素数（可以相等）
     */
    public static int nextPrime(int num) {
        if (num == 0 || num == 1 || num == 2) {
            return 2;
        }
        if (num % 2 == 0) {
            num++;
        }
        while (!isPrime(num)) {
            num += 2;
        }
        return num;
    }

    /**
     * 检查某整数是否为素数
     * @param num 检查整数
     * @return 检查结果
     */
    public static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num == 1 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
