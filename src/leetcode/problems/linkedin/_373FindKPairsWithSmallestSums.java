package leetcode.problems.linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/** 373. Find K Pairs with Smallest Sums
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u, v) which consists of one element from the first array and one element
 * from the second array.
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * Example 3:
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [[1,3],[2,3]]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class _373FindKPairsWithSmallestSums {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // Time: O(N + min(M * N, K) * logN)
            // Space: O(N) + O(1)
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));

            int m = nums1.length;
            int n = nums2.length;
            for(int i = 0; i < n && i < k; i++) { // i < k improves runtime
                pq.offer(new int[] {nums1[0], nums2[i], 0}); // 0 is curr index of element of nums1
            }

            List<List<Integer>> ans = new ArrayList<>();
            while (!pq.isEmpty() && k > 0) {
                List<Integer> pair = new ArrayList<>();
                int[] top = pq.poll();
                pair.add(top[0]);
                pair.add(top[1]);
                ans.add(pair);
                k--;

                if (top[2] + 1 == m) continue;

                int curr = top[2] + 1; // keep track curr element in nums1 and add next element and its index to the queue
                top[2] = curr;
                top[0] = nums1[curr];
                pq.offer(top);
            }

            return ans;
        }
    }
}
