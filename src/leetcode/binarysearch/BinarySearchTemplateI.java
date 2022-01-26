package leetcode.binarysearch;

/**
 * Key Attributes:
 *     Most basic and elementary form of Binary Search
 *     Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
 *     No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found
 *
 * Distinguishing Syntax:
 *     Initial Condition: left = 0, right = length-1
 *     Termination: left > right
 *     Searching Left: right = mid-1
 *     Searching Right: left = mid+1
 */
public class BinarySearchTemplateI {

    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }

}
