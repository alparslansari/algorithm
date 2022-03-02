package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 515. Find Largest Value in Each Tree Row
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 *
 * Example 2:
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 * Constraints:
 *     The number of nodes in the tree will be in the range [0, 104].
 *     -231 <= Node.val <= 231 - 1
 */
public class _515FindLargestValueInEachTreeRow {

    // Preorder traversal
    //Just a simple pre-order traverse idea. Use depth to expand result list size and put the max value in the appropriate position.
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null) return;

        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}
