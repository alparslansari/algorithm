package leetcode.problems.linkedin;

/** 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * Given an array of integers arr and two integers k and threshold, return the number of
 * sub-arrays of size k and average greater than or equal to threshold.
 *
 * Example 1:
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
 * All other sub-arrays of size 3 have averages less than 4 (the threshold).
 *
 * Example 2:
 * Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * Output: 6
 * Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 *
 * Constraints:
 *     1 <= arr.length <= 105
 *     1 <= arr[i] <= 104
 *     1 <= k <= arr.length
 *     0 <= threshold <= 104
 */
public class _1343NumberOfSubArraysOfSizeKAndAverageGreaterThanorEqualToThreshold {

    public int numOfSubarraysV1(int[] a, int k, int threshold) {
        int n = a.length, count = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i)
            prefixSum[i + 1] = prefixSum[i] + a[i];
        for (int i = 0; i + k <= n; ++i)
            if (prefixSum[i + k] - prefixSum[i] >= k * threshold)
                ++count;
        return count;
    }

    public int numOfSubarraysV2(int[] a, int k, int threshold) {
        int count = 0;
        for (int lo = -1, hi = 0, sumOfWin = 0, target = k * threshold; hi < a.length; ++hi) {
            sumOfWin += a[hi];
            if (hi - lo == k) { // Has the width of the window  reached k?
                if (sumOfWin >= target) {
                    ++count;
                }
                sumOfWin -= a[++lo];
            }
        }
        return count;
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt = 0;  // s for sum of sliding window, cnt for count
        int t = k * threshold; // t is the min sum for subarr of k len sliding window
        int s=0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];  // accumulative sum adding head
            if (i < k - 1) continue;  // wait until threshhold.
            if (i > k - 1) s -= arr[i - k];  // accumulative sum substract tail
            if (s >= t) cnt++;  // found one
        }
        return cnt;
    }
}
