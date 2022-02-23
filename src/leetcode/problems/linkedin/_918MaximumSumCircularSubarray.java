package leetcode.problems.linkedin;

/** 918. Maximum Sum Circular Subarray
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * A circular array means the end of the array connects to the beginning of the array.
 * Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once.
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 * Example 1:
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 *
 * Example 2:
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 *
 * Example 3:
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 *
 * Constraints:
 *     n == nums.length
 *     1 <= n <= 3 * 104
 *     -3 * 104 <= nums[i] <= 3 * 104
 */
public class _918MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        if(A.length == 0) return 0;
        int total = A[0];
        int max = A[0];
        int maxtot = A[0];
        int min = A[0];
        int mintot = A[0];
        for(int i = 1;i<A.length;i++)
        {
            max = Math.max(A[i],max+A[i]);
            maxtot = Math.max(max,maxtot);
            min = Math.min(A[i],min+A[i]);
            mintot = Math.min(min,mintot);
            total += A[i];
        }

        if(total == min) return maxtot;
        else return Math.max(total - mintot, maxtot);

    }
}
