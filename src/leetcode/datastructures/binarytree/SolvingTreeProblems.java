package leetcode.datastructures.binarytree;

import leetcode.models.TreeNode;

public class SolvingTreeProblems {


    /**
     * "Top-down" Solution
     * "Top-down" means that in each recursive call, we will visit the node first to come up
     * with some values, and pass these values to its children when calling the function recursively.
     * So the "top-down" solution can be considered as a kind of preorder traversal.
     * To be specific, the recursive function top_down(root, params) works like this:
     *
     * 1. return specific value for null node
     * 2. update the answer if needed                      // answer <-- params
     * 3. left_ans = top_down(root.left, left_params)      // left_params <-- root.val, params
     * 4. right_ans = top_down(root.right, right_params)   // right_params <-- root.val, params
     * 5. return the answer if needed                      // answer <-- left_ans, right_ans
     *
     * For instance, consider this problem: given a binary tree, find its maximum depth.
     * Here we will define the depth of the root node as 1 (although often, the depth of the root node
     * is defined as 0). For each node, if we know its depth, we will know the depth of its children.
     * Therefore, if we pass the depth of the node as a parameter when calling the function recursively,
     * all the nodes will know their depth. And for leaf nodes, we can use the depth to update the final
     * answer. Here is the pseudocode for the recursive function maximum_depth(root, depth):
     *
     * 1. return if root is null
     * 2. if root is a leaf node:
     * 3.     answer = max(answer, depth)         // update the answer if needed
     * 4. maximum_depth(root.left, depth + 1)     // call the function recursively for left child
     * 5. maximum_depth(root.right, depth + 1)    // call the function recursively for right child
     */
    private int answer; // don't forget to initialize answer before call maximum_depth
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }


    /**
     * "Bottom-up" Solution
     * "Bottom-up" is another recursive solution. In each recursive call, we will firstly call the function
     * recursively for all the children nodes and then come up with the answer according to the returned values
     * and the value of the current node itself. This process can be regarded as a kind of postorder traversal.
     * Typically, a "bottom-up" recursive function bottom_up(root) will be something like this:
     *
     * 1. return specific value for null node
     * 2. left_ans = bottom_up(root.left)      // call function recursively for left child
     * 3. right_ans = bottom_up(root.right)    // call function recursively for right child
     * 4. return answers                       // answer <-- left_ans, right_ans, root.va
     *
     * 1. return 0 if root is null                 // return 0 for null node
     * 2. left_depth = maximum_depth(root.left)
     * 3. right_depth = maximum_depth(root.right)
     * 4. return max(left_depth, right_depth) + 1  // return depth of the subtree rooted at root
     */
    public int maximum_depth(TreeNode root) {
        if (root == null) {
            return 0;                                   // return 0 for null node
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;   // return depth of the subtree rooted at root
    }

}
