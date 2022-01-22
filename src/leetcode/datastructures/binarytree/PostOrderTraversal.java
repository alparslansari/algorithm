package leetcode.datastructures.binarytree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraversal(root, answer);
        return answer;
    }

    private void postorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) return;
        postorderTraversal(root.left, answer);   // traverse left subtree
        postorderTraversal(root.right, answer);  // traverse right subtree
        answer.add(root.val);                    // visit the root
    }

}
