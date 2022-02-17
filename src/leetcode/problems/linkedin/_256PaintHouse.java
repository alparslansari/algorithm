package leetcode.problems.linkedin;

/**
 * 256. Paint House
 * There is a row of n houses, where each house can be painted one of three colors:
 * red, blue, or green. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 * For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2]
 * is the cost of painting house 1 with color green, and so on...
 * <p>
 * Return the minimum cost to paint all houses.
 * Example 1:
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 * <p>
 * Example 2:
 * Input: costs = [[7,6,2]]
 * Output: 2
 */
public class _256PaintHouse {
    public int minCost(int[][] costs) {
        for (int n = costs.length - 2; n >= 0; n--) {
            // Total cost of painting the nth house red.
            costs[n][0] += Math.min(costs[n + 1][1], costs[n + 1][2]);
            // Total cost of painting the nth house green.
            costs[n][1] += Math.min(costs[n + 1][0], costs[n + 1][2]);
            // Total cost of painting the nth house blue.
            costs[n][2] += Math.min(costs[n + 1][0], costs[n + 1][1]);
        }
        if (costs.length == 0) return 0;
        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}
