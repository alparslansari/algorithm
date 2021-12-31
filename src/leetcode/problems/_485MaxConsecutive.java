package leetcode.problems;

/** 485. Max Consecutive Ones
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 * Constraints:
 *     1 <= nums.length <= 105
 *     nums[i] is either 0 or 1.
 */
public class _485MaxConsecutive {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currLength = 0;
        int prevLength = 0;
        for(int num: nums)
        {
            if(num == 1) currLength++;
            else {
                if(currLength>prevLength) prevLength = currLength;
                currLength = 0;
            }
        }
        return currLength > prevLength ? currLength : prevLength;
    }

    public int findMaxConsecutiveOnesV2(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment the count of 1's by one.
                count += 1;
            } else {
                // Find the maximum till now.
                maxCount = Math.max(maxCount, count);
                // Reset count of 1.
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}
