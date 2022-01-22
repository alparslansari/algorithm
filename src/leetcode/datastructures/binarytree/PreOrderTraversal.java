package leetcode.datastructures.binarytree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorderTraversal(root, answer);
        return answer;
    }

    private void preorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) return;               // base condition
        answer.add(root.val);                   // visit the root
        preorderTraversal(root.left, answer);   // traverse left subtree
        preorderTraversal(root.right, answer);  // traverse right subtree
    }
}
