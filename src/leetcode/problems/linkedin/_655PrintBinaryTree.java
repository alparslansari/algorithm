package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 655. Print Binary Tree
 * Given the root of a binary tree, construct a 0-indexed m x n string matrix res that
 * represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:
 * The height of the tree is height and the number of rows m should be equal to height + 1.
 * The number of columns n should be equal to 2height+1 - 1.
 * Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
 * For each node that has been placed in the matrix at position res[r][c], place its left child at
 * res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
 * Continue this process until all the nodes in the tree have been placed.
 * Any empty cells should contain the empty string "".
 *
 * Return the constructed matrix res.
 *
 * Example 1:
 * Input: root = [1,2]
 * Output:
 * [["","1",""],
 *  ["2","",""]]
 *
 * Example 2:
 * Input: root = [1,2,3,null,4]
 * Output:
 * [["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]]
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [1, 210].
 *     -99 <= Node.val <= 99
 *     The depth of the tree will be in the range [1, 10].
 */
public class _655PrintBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new LinkedList<>();
        int rows = root == null ? 1 : getHeight(root); // height of the tree
        int columns = (int) (Math.pow(2, rows) - 1);   // width of the tree
        List<String> row = new ArrayList<>();
        for(int i = 0; i < columns; i++)  row.add("");
        for(int i = 0; i < rows; i++)  res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, columns - 1);
        return res;
    }

    public void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) return;
        res.get(row).set((i+j)/2, Integer.toString(root.val));
        populateRes(root.left, res, row+1, totalRows, i, (i+j)/2 - 1);
        populateRes(root.right, res, row+1, totalRows, (i+j)/2+1, j);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
