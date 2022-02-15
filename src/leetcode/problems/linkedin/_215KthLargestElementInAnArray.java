package leetcode.problems.linkedin;

import java.util.Arrays;
import java.util.PriorityQueue;

/** 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return
 * the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class _215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // Array.sort time complexity O(n log n)
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargestV2(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2)->n1-n2);
        // keep k largest elements in the heap
        for(int n:nums){
            heap.add(n);
            if(heap.size()>k) heap.poll();
        }
        return heap.poll(); // Kth largest element
    }
}
