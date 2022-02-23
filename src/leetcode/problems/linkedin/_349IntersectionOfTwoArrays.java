package leetcode.problems.linkedin;

import java.util.Arrays;
import java.util.HashSet;

/** 349. Intersection of Two Arrays
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 * Constraints:
 *  1 <= nums1.length, nums2.length <= 1000
 *  0 <= nums1[i], nums2[i] <= 1000
 */
public class _349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(Integer n:nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<>();
        for(Integer n:nums2) set2.add(n);

        if(set1.size()<set2.size()) return helper(set1,set2);
        return helper(set2,set1);
    }

    public int[] helper(HashSet<Integer> small, HashSet<Integer> large)
    {
        int[] output = new int[small.size()];
        int idx = 0;
        for(Integer ele:small)
            if(large.contains(ele)) output[idx++] = ele;
        return Arrays.copyOf(output, idx);
    }
}
