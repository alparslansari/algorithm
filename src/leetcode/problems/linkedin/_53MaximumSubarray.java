package leetcode.problems.linkedin;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubArray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubArray = Math.max(currentSubarray, maxSubArray);
        }

        return maxSubArray;
    }
}
