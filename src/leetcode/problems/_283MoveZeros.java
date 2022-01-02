package leetcode.problems;

/** 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 *     1 <= nums.length <= 104
 *     -231 <= nums[i] <= 231 - 1
 */
public class _283MoveZeros {
    public void moveZeroes(int[] nums){
        int availablePosition = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] !=0 ) {
                nums[availablePosition] = nums[i];
                availablePosition++;
            }
        }
        for(int i=availablePosition;i<nums.length;i++) nums[i] = 0;
    }
}
