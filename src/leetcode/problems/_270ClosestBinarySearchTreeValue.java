package leetcode.problems;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 270. Closest Binary Search Tree Value
 * Given the root of a binary search tree and a target value, return the value in the BST
 * that is closest to the target.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 *
 * Example 2:
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [1, 104].
 *     0 <= Node.val <= 109
 *     -109 <= target <= 109
 */
public class _270ClosestBinarySearchTreeValue {

    /** Approach 1: Recursive Inorder + Linear search, O(N) time */
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int closestValue(TreeNode root, double target) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        return Collections.min(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
    }

    /** Approach 3: Binary Search, O(H) time */
    public int closestValueV2(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
