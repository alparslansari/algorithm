package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/** 509. Fibonacci Number
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * Given n, calculate F(n).
 *
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * Constraints:
 *     0 <= n <= 30
 */
public class _509FibonacciNumber {

    // Using Iterative
    public int fibonacci(int n)
    {
        if(n<=1) return n;
        int current = 0;
        int prev1 = 1;
        int prev2 = 0;
        for(int i=2;i<=n;i++)
        {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    // Using Tabulation
    public int fibonacciV1(int n)
    {
        if(n<=1) return n;
        int[] cache = new int[n+1];
        cache[1] = 1;
        for(int i = 2; i<=n;i++)
            cache[i] = cache[i-1]+cache[i-2];
        return cache[n];
    }

    // Using memoization
    private Map<Integer, Integer> cache = new HashMap<>(Map.of(0,0,1,1));
    public int fib(int N) {
        if(cache.containsKey(N)) return cache.get(N);
        cache.put(N, fib(N-1)+fib(N-2));
        return cache.get(N);
    }

    // Math solution
    public int fibGolden(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
    }
}
