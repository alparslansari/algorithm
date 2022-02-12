package leetcode.problems.linkedin;

/** 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class _34FindFirstAndLastPositionOfElementInSortedArray {
    /** Approach: Brute Force O(n)
     * Not a good solution since it is not taking advantage of
     * array being sorted.
     */
    public int[] searchRange(int[] nums, int target) {
        int start =-1;
        int end =-1;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == target)
                if(start!=-1) end = i;
                else start = i;
        }
        if(start != -1 && end == -1) end = start;
        return new int[] {start, end};
    }
    /** Approach: Binary Search
     * Time Complexity O(logN)
     */
    public int[] searchRangeBinary(int[] nums, int target) {
        int firstOccurrence = this.findBound(nums, target, true);
        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }
        int lastOccurrence = this.findBound(nums, target, false);
        return new int[]{firstOccurrence, lastOccurrence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    // This means we found our lower bound.
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }
                    // Search on the left side for the bound.
                    end = mid - 1;
                } else {
                    // This means we found our upper bound.
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    // Search on the right side for the bound.
                    begin = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
