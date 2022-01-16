package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/** 202. Happy Number
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 *     Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *     Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Constraints:
 *     1 <= n <= 2^31 - 1
 */
public class _202HappyNumber {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10; // get last digit
            n = n / 10; // 891 to 89 etc. finding next number
            totalSum += d * d;
        }
        return totalSum;
    }

    // Approach 1: Detect Cycles with a HashSet
    public boolean isHappyWithHash(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // Approach 2: Floyd's Cycle-Finding Algorithm
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
