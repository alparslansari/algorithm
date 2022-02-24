package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.HashMap;
import java.util.Map;

/** 653. Two Sum IV - Input is a BST
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 * Constraints:
 *  The number of nodes in the tree is in the range [1, 104].
 *  -104 <= Node.val <= 104
 *  root is guaranteed to be a valid binary search tree.
 *  -105 <= k <= 105
 *
 * Accepted
 * 288,078
 * Submissions
 * 491,954
 */
public class _653TwoSumIVInputIsABST {
    Map<Integer,Integer> map;
    boolean isFound = false;

    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        return targetFinder(root, k);
    }

    private boolean targetFinder(TreeNode root, int k)
    {
        if(root==null) return false;
        if(this.isFound == true) return true;
        if(map.containsKey(root.val)) {
            this.isFound = true;
            return true;
        } else {
            map.put(k-root.val, 0);
        }
        return targetFinder(root.left, k) || targetFinder(root.right, k);
    }

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public boolean findTarget(TreeNode root, int k) {
            if(root==null) return false;

            if(map.containsKey(root.val)) {
                return true;
            }
            map.put(k-root.val, 0);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }

    }
}
