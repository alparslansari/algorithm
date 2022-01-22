package leetcode.problems;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _144BinaryTreePreorderTraversal {

    /**
     * Solving using a recursive function
     */
    final List<Integer> l = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return l;
        l.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return l;
    }

    /**
     * Approach 2: Iterations
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root==null) return output;
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return output;
    }

    /**
     * Approach 3: Morris traversal
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            if(node.left==null) {
                output.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node))
                    predecessor = predecessor.right;
                if(predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }

}
