package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/** 350. Intersection of Two Arrays II
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 * Constraints:
 *     1 <= nums1.length, nums2.length <= 1000
 *     0 <= nums1[i], nums2[i] <= 1000
 * Follow up:
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class _350IntersectionOfTwoArraysII {
    // Approach 1: Hash Map
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        HashMap<Integer, Integer> m = new HashMap<>();
        for(int n : nums1)
            m.put(n, m.getOrDefault(n,0)+1);
        int k=0;
        for(int n: nums2) {
            int cnt = m.getOrDefault(n,0);
            if(cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    // Approach 2: Sort
    public int[] intersectSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j = 0, k = 0;
        while(i<nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }



    public int[] intersectMine(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map_nums1 = new HashMap<>();
        ArrayList<Integer> solution = new ArrayList<>();

        for(int n: nums1)
        {
            if(map_nums1.containsKey(n))
            {
                map_nums1.put(n,map_nums1.get(n)+1);
            } else {
                map_nums1.put(n,1);
            }
        }
        for(int n: nums2)
        {
            if(map_nums1.containsKey(n))
            {
                solution.add(n);
                if(map_nums1.get(n) >1) map_nums1.put(n,map_nums1.get(n)-1);
                else map_nums1.remove(n);
            }
        }
        return solution.stream().mapToInt(i -> i).toArray();
    }

}
