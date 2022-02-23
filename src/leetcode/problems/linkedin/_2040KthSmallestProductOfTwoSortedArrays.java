package leetcode.problems.linkedin;

/**
 * 2040. Kth Smallest Product of Two Sorted Arrays
 * Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 * <p>
 * Example 1:
 * Input: nums1 = [2,5], nums2 = [3,4], k = 2
 * Output: 8
 * Explanation: The 2 smallest products are:
 * - nums1[0] * nums2[0] = 2 * 3 = 6
 * - nums1[0] * nums2[1] = 2 * 4 = 8
 * The 2nd smallest product is 8.
 * <p>
 * Example 2:
 * Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
 * Output: 0
 * Explanation: The 6 smallest products are:
 * - nums1[0] * nums2[1] = (-4) * 4 = -16
 * - nums1[0] * nums2[0] = (-4) * 2 = -8
 * - nums1[1] * nums2[1] = (-2) * 4 = -8
 * - nums1[1] * nums2[0] = (-2) * 2 = -4
 * - nums1[2] * nums2[0] = 0 * 2 = 0
 * - nums1[2] * nums2[1] = 0 * 4 = 0
 * The 6th smallest product is 0.
 * <p>
 * Example 3:
 * Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
 * Output: -6
 * Explanation: The 3 smallest products are:
 * - nums1[0] * nums2[4] = (-2) * 5 = -10
 * - nums1[0] * nums2[3] = (-2) * 4 = -8
 * - nums1[4] * nums2[0] = 2 * (-3) = -6
 * The 3rd smallest product is -6.
 * <p>
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 5 * 104
 * -105 <= nums1[i], nums2[j] <= 105
 * 1 <= k <= nums1.length * nums2.length
 * nums1 and nums2 are sorted.
 */
public class _2040KthSmallestProductOfTwoSortedArrays {
    /**
     * Approach
     * <p>
     * Do Binary Search from negative limit -1e10 to positive limit 1e10 for the value val from the first array
     * Do Binary search for the length of the second array from 0 to nums2.length - 1
     * Multiply the value each time with the mid value from the second array and see if its less that or greater and count cnt accordingly
     * Eventually the k smallest element will be found and the lo value will be returned
     */
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = (long) -1e10;
        long hi = (long) 1e10;

        while (lo < hi) {
            long mid = lo + ((hi - lo) >> 1);
            long cnt = 0;

            for (int val : nums1)
                cnt += (val >= 0) ? binary_search(mid, val, nums2, true) : binary_search(mid, val, nums2, false);

            if (cnt >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public long binary_search(long mid, int i, int[] nums2, boolean positive) {
        int l = 0;
        int r = nums2.length - 1;
        int res = 0;

        while (l <= r) {
            int c = l + ((r - l) >> 1);
            long mul = i * (long) nums2[c];
            if (mul <= mid) {
                if (positive) {
                    l = c + 1;
                    res = c + 1;
                } else {
                    r = c - 1;
                    res = nums2.length - c;
                }
            } else {
                if (positive) r = c - 1;
                else l = c + 1;
            }
        }
        return res;
    }
}
