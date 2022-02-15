package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.*;

/**
 * 272. Closest Binary Search Tree Value II
 * Given the root of a binary search tree, a target value, and an integer k,
 * return the k values in the BST that are closest to the target. You may return
 * the answer in any order.
 * <p>
 * You are guaranteed to have only one unique set of k values in the BST that are closest to
 * the target.
 * <p>
 * Example 1:
 * Input: root = [4,2,5,1,3], target = 3.714286, k = 2
 * Output: [4,3]
 * <p>
 * Example 2:
 * Input: root = [1], target = 0.000000, k = 1
 * Output: [1]
 */
public class _272ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
        return nums.subList(0, k);
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     * DeQueue Solution
     */
    public List<Integer> closestKValuesV2(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inorder(deque, root, target, k);
        return new ArrayList(deque);
    }

    private void inorder(Deque<Integer> deque, TreeNode node, double target, int k) {
        if (node == null)
            return;
        inorder(deque, node.left, target, k);
        double val = Double.valueOf(node.val);
        if (deque.size() == k) {
            if (Math.abs(Double.valueOf(deque.peekFirst()) - target) > Math.abs(val - target)) {
                deque.pollFirst();
                deque.addLast(node.val);
            } else return;
        } else {
            deque.addLast(node.val);
        }
        inorder(deque, node.right, target, k);
    }
}
