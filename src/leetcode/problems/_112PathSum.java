package leetcode.problems;

import leetcode.models.TreeNode;

import java.util.LinkedList;

/**
 * 112. Path Sum
 * Given the root of a binary tree and an integer targetSum, return true
 * if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class _112PathSum {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    // Approach 1: Recursion
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if((root.left==null) && (root.right==null)) return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right,sum);
    }

    // Approach 2: Iterations
    public boolean hasPathSumIterations(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }
}
