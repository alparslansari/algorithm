package leetcode.problems.linkedin;

/** 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class _70ClimbingStairs {

    public int climbStairs(int n) {
        //return recursiveSolution(0, n); // 2^n time
        //int memo[] = new int[n+1];
        //return memoizationSolution(0, n, memo);
        return dynamicSolution(n);
    }

    private int recursiveSolution(int i, int n)
    {
        if (i > n) return 0;
        if(i == n) return 1;
        return recursiveSolution(i+1, n) + recursiveSolution(i+2, n);
    }

    private int memoizationSolution(int i, int n, int[] memo)
    {
        if(i>n) return 0;
        if(i==n) return 1;
        if(memo[i] > 0) return memo[i];
        memo[i] = memoizationSolution(i+1,n,memo) + memoizationSolution(i+2,n,memo);
        return memo[i];
    }

    private int dynamicSolution(int n)
    {
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
