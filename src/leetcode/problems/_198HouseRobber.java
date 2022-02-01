package leetcode.problems;

import java.util.Arrays;

/** 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class _198HouseRobber {

    public int rob(int[] nums) {
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i>2) nums[i] = Math.max(nums[i-2], nums[i-3]) + nums[i];
            else if (i>1) nums[i] = nums[i-2]+nums[i];

            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /** Recursion with Memoization */
    private int[] memo;
    public int rob1(int[] nums){
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        return this.robForm(0, nums);
    }

    private int robForm(int i, int[] nums) {
        // No more houses left to examine
        if(i>=nums.length) return 0;
        // Return cached value.
        if(this.memo[i]>-1) return this.memo[i];
        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robForm(i+1,nums), this.robForm(i+2,nums)+nums[i]);
        // cache for future use.
        this.memo[i] = ans;
        return ans;
    }

    /** Dynamic Programming */
    public int rob2(int[] nums)
    {
        int N = nums.length;
        // Handle empty array
        if(N==0) return 0;
        int[] maxRobbedAmount = new int[nums.length+1];
        // Base case initialization.
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N-1] = nums[N-1];
        // DP table calculations
        for(int i=N-2;i>=0;i--)
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        return maxRobbedAmount[0];
    }

    /** Optimized Dynamic Programming */
    public int rob3(int[] nums) {
        int N = nums.length;
        // Special handling for empty array case.
        if (N == 0) return 0;
        int robNext, robNextPlusOne;
        // Base case initializations.
        robNextPlusOne = 0;
        robNext= nums[N - 1];
        // DP table calculations. Note: we are not using any
        // table here for storing values. Just using two
        // variables will suffice.
        for (int i = N - 2; i >= 0; --i) {
            // Same as the recursive solution.
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            // Update the variables
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }

}
