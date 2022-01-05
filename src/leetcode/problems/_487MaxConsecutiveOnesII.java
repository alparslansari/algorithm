package leetcode.problems;

/** 487. Max Consecutive Ones II
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 * Example 1:
 * Input: nums = [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.
 *
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 4
 *
 * Constraints:
 *     1 <= nums.length <= 105
 *     nums[i] is either 0 or 1.
 * Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */
public class _487MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums){
        int currentCnt = 0;
        int consecutiveCnt = 0;
        int maxCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currentCnt++;
                consecutiveCnt++;
            } else {
                currentCnt = consecutiveCnt;
                currentCnt++;
                consecutiveCnt = 0;
            }
            if(currentCnt>maxCnt) maxCnt = currentCnt;
        }
        return maxCnt;
    }
}
