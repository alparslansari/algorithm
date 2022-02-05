package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

/** 156. Binary Tree Upside Down
 * Given the root of a binary tree, turn the tree upside down and return the new root.
 * You can turn a binary tree upside down with the following steps:
 *     The original left child becomes the new root.
 *     The original root becomes the new right child.
 *     The original right child becomes the new left child.
 * The mentioned steps are done level by level. It is guaranteed that every right node has a sibling (a left node with the same parent) and has no children.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: [4,5,2,null,null,3,1]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 *     The number of nodes in the tree will be in the range [0, 10].
 *     1 <= Node.val <= 10
 *     Every right node in the tree has a sibling (a left node that shares the same parent).
 *     Every right node in the tree has no children.
 */
public class _156BinaryTreeUpsideDown {

    /** Recursive */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    /** Iterative */
    public TreeNode upsideDownBinaryTreeV2(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;
        while(curr!=null) {
            next = curr.left;
            //  // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
