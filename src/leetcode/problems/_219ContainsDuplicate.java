package leetcode.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/** 219. Contains Duplicate II
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * Constraints:
 *     1 <= nums.length <= 10^5
 *     -109 <= nums[i] <= 10^9
 *     0 <= k <= 10^5
 */
public class _219ContainsDuplicate {

    // Approach #1: Naive Linear Search
    public boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        for(int i = 0; i< nums.length; i++)
            for(int j=Math.max(i-k,0);j<i;j++)
                if(nums[i] == nums[j]) return true;
        return false;
    }

    // Approach #2: Binary Search Tree
    // Keep a sliding window of kkk elements using self-balancing Binary Search Tree (BST).
    public boolean containsNearbyDuplicateBinaryTree(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
