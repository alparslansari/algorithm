package leetcode.problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/** 414. Third Maximum Number
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 * Example 1:
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 *
 * Example 2:
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *
 * Constraints:
 *     1 <= nums.length <= 10^4
 *     -2^31 <= nums[i] <= 2^31 - 1
 */
public class _414ThirdMaximumNumber {

    public int thirdMaxSet(int[] nums) {

        // Put the input integers into a HashSet.
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) setNums.add(num);

        // Find the maximum.
        int maximum = Collections.max(setNums);

        // Check whether or not this is a case where we
        // need to return the *maximum*.
        if (setNums.size() < 3) {
            return maximum;
        }

        // Otherwise, continue on to finding the third maximum.
        setNums.remove(maximum);
        int secondMaximum = Collections.max(setNums);
        setNums.remove(secondMaximum);
        return Collections.max(setNums);
    }

    public int thirdMaxPriorityQueue(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        Integer max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (set.contains(n)) continue;
            max = Math.max(n, max);
            queue.add(n);
            if (queue.size() > 3) queue.poll();
            set.add(n);
        }

        if (queue.size() == 3) return queue.peek();
        return max;
    }
}
