package leetcode.problems.linkedin;

import java.util.LinkedList;
import java.util.List;

/**
 * 254. Factor Combinations
 * Numbers can be regarded as the product of their factors.
 * <p>
 * For example, 8 = 2 x 2 x 2 = 2 x 4.
 * <p>
 * Given an integer n, return all possible combinations of its factors.
 * You may return the answer in any order.
 * <p>
 * Note that the factors should be in the range [2, n - 1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: []
 * <p>
 * Example 2:
 * <p>
 * Input: n = 12
 * Output: [[2,6],[3,4],[2,2,3]]
 * <p>
 * Example 3:
 * <p>
 * Input: n = 37
 * Output: []
 */
public class _254FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(2, n, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, List<Integer> list, List<List<Integer>> result) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
                result.add(new LinkedList<>(list));
                list.remove(list.size() - 1);
                backtrack(i, n / i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
