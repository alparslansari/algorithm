package leetcode.problems;

/** 69. Sqrt(x)
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.

 * Example 1:
 * Input: x = 4
 * Output: 2
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated,
 * 2 is returned.
 */
public class _69Sqrt {

    /** Approach 1: Binary Search */
    public int mySqrtV1(int x) {
        if (x < 2) return x;
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }

    /** Approach 2: Recursion + Bit Shifts */
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}
