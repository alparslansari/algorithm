package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

/** 235. Lowest Common Ancestor of a Binary Search Tree
 *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given
 *  nodes in the BST. According to the definition of LCA on Wikipedia:
 *  “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 *  that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * Example 3:
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 */
public class _235LowestCommonAncestorOfABinarySearchTree {
    /** Approach 1: Recursive Approach */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else return root;
    }

    /** Approach 2: Iterative (Slower than recursive) */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                // If both p and q are greater than parent
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                // If both p and q are lesser than parent
                root = root.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return root;
            }
        }
        return null;
    }
}
