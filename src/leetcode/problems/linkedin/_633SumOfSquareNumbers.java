package leetcode.problems.linkedin;

/** 633. Sum of Square Numbers
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: c = 3
 * Output: false
 *
 * Constraints:
 *     0 <= c <= 231 - 1
 */
public class _633SumOfSquareNumbers {

    // Using Fermat Theorem
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    // Using built-in sqrt
    public boolean judgeSquareSumV2(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }

    // Brute force - time limit exceeds
    public boolean judgeSquareSumV1(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b =  c - (int)(a * a);
            int i = 1, sum = 0;
            while (sum < b) {
                sum += i;
                i += 2;
            }
            if (sum == b)
                return true;
        }
        return false;
    }
}
