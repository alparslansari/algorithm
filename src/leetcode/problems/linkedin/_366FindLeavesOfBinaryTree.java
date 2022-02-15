package leetcode.problems.linkedin;

import leetcode.models.Pair;
import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 366. Find Leaves of Binary Tree
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *     Collect all the leaf nodes.
 *     Remove all the leaf nodes.
 *     Repeat until the tree is empty.
 */
public class _366FindLeavesOfBinaryTree {

    /** Approach 2: DFS (Depth-First Search) without sorting **/
    // faster than DFS with sorting
    private List<List<Integer>> solution;
    private int getHeightDFS(TreeNode root) {
        if (root == null) return -1;
        // first calculate the height of the left and right children
        int leftHeight = getHeightDFS(root.left);
        int rightHeight = getHeightDFS(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if (this.solution.size() == currHeight) {
            this.solution.add(new ArrayList<>());
        }
        this.solution.get(currHeight).add(root.val);
        return currHeight;
    }

    public List<List<Integer>> findLeavesDFS(TreeNode root) {
        this.solution = new ArrayList<>();
        getHeightDFS(root);
        return this.solution;
    }

    /** Approach: DFS (Depth-First Search) with sorting */
    private List<Pair<Integer, Integer>> pairs;

    private int getHeight(TreeNode root){
        if(root==null) return -1;
        // calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // based on the height of the left and right children, obtain the height of the current (parent) node
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        // collect the pair -> (height, val)
        this.pairs.add(new Pair<Integer, Integer>(currHeight, root.val));
        // return the height of the current node
        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.pairs = new ArrayList<>();
        getHeight(root);
        // sort all the (height, val) pairs
        Collections.sort(this.pairs, Comparator.comparing(p->p.getKey()));
        int n = this.pairs.size(), height=0,i=0;
        List<List<Integer>> solution = new ArrayList<>();
        while(i<n){
            List<Integer> nums = new ArrayList<>();
            while(i<n && this.pairs.get(i).getKey()==height) {
                nums.add(this.pairs.get(i).getValue());
                i++;
            }
            solution.add(nums);
            height++;
        }
        return solution;
    }
}
