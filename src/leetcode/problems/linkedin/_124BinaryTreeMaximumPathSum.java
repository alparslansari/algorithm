package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence
 * has an edge connecting them. A node can only appear in the sequence at most once. Note that the path
 * does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * <p>
 * Example 2:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3 * 104].
 */
public class _124BinaryTreeMaximumPathSum {
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}
