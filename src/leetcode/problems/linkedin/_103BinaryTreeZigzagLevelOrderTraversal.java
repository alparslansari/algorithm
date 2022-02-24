package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -100 <= Node.val <= 100
 */
public class _103BinaryTreeZigzagLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
            if (level >= results.size()) {
                LinkedList<Integer> newLevel = new LinkedList<Integer>();
                newLevel.add(node.val);
                results.add(newLevel);
            } else {
                if (level % 2 == 0)
                    results.get(level).add(node.val);
                else
                    results.get(level).add(0, node.val);
            }

            if (node.left != null) DFS(node.left, level + 1, results);
            if (node.right != null) DFS(node.right, level + 1, results);
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<List<Integer>>();
            }
            List<List<Integer>> results = new ArrayList<List<Integer>>();
            DFS(root, 0, results);
            return results;
        }
    }
}
