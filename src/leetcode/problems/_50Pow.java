package leetcode.problems;

/** 50. Pow
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class _50Pow {
    // java.lang.StackOverflowError
    public double myPowV1(double x, int n) {
        if(n==0) return 1;
        return x * myPowV1(x,n-1);
    }

    // Time Limit Exceeded
    public double myPowV2(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        double result = x;
        boolean isNegative = false;
        if(n < 0) {
            isNegative = true;
            n = n*(-1);
        }
        for(int i = 2; i<=n; i++)
            result = result * x;
        if(isNegative) result = 1 / result;
        return result;
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
