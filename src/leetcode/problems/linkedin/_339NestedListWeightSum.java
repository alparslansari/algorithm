package leetcode.problems.linkedin;

import leetcode.models.NestedInteger;

import java.util.List;

/**
 * 339. Nested List Weight Sum
 * You are given a nested list of integers nestedList. Each element is either an integer
 * or a list whose elements may also be integers or other lists.
 * <p>
 * The depth of an integer is the number of lists that it is inside of.
 * For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 * <p>
 * Return the sum of each integer in nestedList multiplied by its depth.
 * <p>
 * Example 1:
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 * <p>
 * Example 2:
 * Input: nestedList = [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
 * <p>
 * Example 3:
 * Input: nestedList = [0]
 * Output: 0
 */
public class _339NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return calcSum(nestedList, 1);
    }

    private int calcSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) sum += ni.getInteger() * depth;
            else {
                sum += calcSum(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}
