package leetcode.problems;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class _145BinaryTreePostorderTraversal {
    List postorderList = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return postorderList;
    }

    public void postorder(TreeNode node)
    {
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.val);
    }
}
