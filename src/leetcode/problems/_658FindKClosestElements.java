package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 658. Find K Closest Elements
 * Given a sorted integer array arr, two integers k and x, return the k closest integers
 * to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *     |a - x| < |b - x|, or
 *     |a - x| == |b - x| and a < b
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * Constraints:
 *     1 <= k <= arr.length
 *     1 <= arr.length <= 104
 *     arr is sorted in ascending order.
 *     -104 <= arr[i], x <= 104
 */
public class _658FindKClosestElements {
    /** Approach 1: Sort With Custom Comparator */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Convert from array to list first to make use of Collections.sort()
        List<Integer> sortedArr = new ArrayList<Integer>();
        for (int num: arr) {
            sortedArr.add(num);
        }
        // Sort using custom comparator
        //Collections.sort(sortedArr, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
        Collections.sort(sortedArr, Comparator.comparingInt(num -> Math.abs(num - x)));
        // Only take k elements
        sortedArr = sortedArr.subList(0, k);
        // Sort again to have output in ascending order
        Collections.sort(sortedArr);
        return sortedArr;
    }

    /** Approach 2: Binary Search + Sliding Window
     * Every time you see a problem that involves a sorted array,
     * you should consider binary search.
     */
    public List<Integer> findClosestElementsV1(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        // Base case
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }
        // Binary search to find the closest element
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // Initialize our sliding window's bounds
        left -= 1;
        right = left + 1;
        // While the window size is less than k
        while (right - left - 1 < k) {
            // Be careful to not go out of bounds
            if (left == -1) {
                right += 1;
                continue;
            }
            // Expand the window towards the side with the closer number
            // Be careful to not go out of bounds with the pointers
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }
        // Build and return the window
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    /** Approach 3: Binary Search To Find The Left Bound */
    public List<Integer> findClosestElementsV2(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
