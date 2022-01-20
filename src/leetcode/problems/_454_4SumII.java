package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/** 454. 4Sum II
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *     0 <= i, j, k, l < n
 *     nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * Example 1:
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * Example 2:
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 *
 * Constraints:
 *     n == nums1.length
 *     n == nums2.length
 *     n == nums3.length
 *     n == nums4.length
 *     1 <= n <= 200
 *     -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 */
public class _454_4SumII {

    // Approach 1: Hashmap
    public int fourSumCountV1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int n1: nums1)
            for(int n2: nums2)
                m.put(n1+n2, m.getOrDefault(n1+n2,0)+1);
        for(int n3:nums3)
            for(int n4:nums4)
                cnt += m.getOrDefault(-(n3+n4),0);
        return cnt;
    }

    // Approach 2: kSum II
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        return kSumCount(new int[][]{A, B, C, D});
    }
    public int kSumCount(int[][] lists) {
        Map<Integer, Integer> m = new HashMap<>();
        addToHash(lists, m, 0, 0);
        return countComplements(lists, m, lists.length / 2, 0);
    }
    void addToHash(int[][] lists, Map<Integer, Integer> m, int i, int sum) {
        if (i == lists.length / 2)
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        else
            for (int a : lists[i])
                addToHash(lists, m, i + 1, sum + a);
    }
    int countComplements(int[][] lists, Map<Integer, Integer> m, int i, int complement) {
        if (i == lists.length)
            return m.getOrDefault(complement, 0);
        int cnt = 0;
        for (int a : lists[i])
            cnt += countComplements(lists, m, i + 1, complement - a);
        return cnt;
    }
}
