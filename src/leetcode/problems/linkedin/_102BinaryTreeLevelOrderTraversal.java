package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 102. Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 */
public class _102BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public void helper(TreeNode node, int level){
        // start the current level
        if(levels.size() == level)
            levels.add(new ArrayList<Integer>());
        // fullfill the current level
        levels.get(level).add(node.val);
        // process child nodes for the next level
        if(node.left != null)  helper(node.left, level+1);
        if(node.right != null) helper(node.right, level+1);
    }

}
