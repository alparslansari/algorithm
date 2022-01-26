package leetcode.problems;

import java.util.*;

/** 287. Find the Duplicate Number
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Constraints:
 *     1 <= n <= 105
 *     nums.length == n + 1
 *     1 <= nums[i] <= n
 *     All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * Follow up:
 *     How can we prove that at least one duplicate number must exist in nums?
 *     Can you solve the problem in linear runtime complexity?
 */
public class _287FindTheDuplicateNumber {

    /** One pass with extra space usage */
    public int findDuplicateInitial(int[] nums) {
        Map<Integer, Integer> nlist = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nlist.containsKey(nums[i])) return nums[i];
            else {
                nlist.put(nums[i],1);
            }
        }
        return -1;
    }

    /** Approach 1: Sort without extra space usage */
    public int findDuplicateV1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return -1;
    }

    /** Approach 2: Set */
    public int findDuplicateV2(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int num: nums){
            if(seen.contains(num)) return num;
            seen.add(num);
        }
        return -1;
    }

    /** Approach 5: Binary Search */
    public int findDuplicateV5(int[] nums) {
        // 'low' and 'high' represent the range of values of the target
        int low = 1, high = nums.length - 1;
        int duplicate = -1;
        while (low <= high) {
            int cur = (low + high) / 2;
            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) if (num <= cur) count++;

            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;
    }
    /** Approach 7: Floyd's Tortoise and Hare (Cycle Detection) */
    public int findDuplicateV7(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
