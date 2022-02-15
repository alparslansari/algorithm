package leetcode.problems.linkedin;

import leetcode.models.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 364. Nested List Weight Sum II
 * You are given a nested list of integers nestedList. Each element is either an integer
 * or a list whose elements may also be integers or other lists.
 * <p>
 * The depth of an integer is the number of lists that it is inside of.
 * For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 * Let maxDepth be the maximum depth of any integer.
 * <p>
 * The weight of an integer is maxDepth - (the depth of the integer) + 1.
 * <p>
 * Return the sum of each integer in nestedList multiplied by its weight.
 * <p>
 * Example 1:
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
 * 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
 * <p>
 * Example 2:
 * Input: nestedList = [1,[4,[6]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
 * 1*3 + 4*2 + 6*1 = 17
 */
public class _364NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int levelSum = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger nested = queue.remove();
                if (nested.isInteger()) {
                    levelSum += nested.getInteger();
                } else {
                    for (NestedInteger n : nested.getList()) {
                        queue.add(n);
                    }
                }
            }
            result += levelSum;
        }
        return result;
    }
}
