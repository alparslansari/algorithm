package leetcode.problems.linkedin;

import java.util.*;

/**
 * 47. Permutations II
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class _47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums)
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, counter, result);
        return result;
    }

    private void backtrack(LinkedList<Integer> comb, Integer N, HashMap<Integer, Integer> counter, List<List<Integer>> result) {
        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permuation will be backtracked later.
            result.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer cnt = entry.getValue();
            if (cnt == 0) continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, cnt - 1);
            // continue the exploration
            backtrack(comb, N, counter, result);
            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, cnt);
        }
    }
}
