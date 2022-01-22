package leetcode.problems;

/** 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class _116PopulatingNextRightPointersinEachNode {
    /* Approach 1: Level Order Traversal
     public Node connect(Node root) {
        if (root == null) return root;

        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        // Outer while loop which iterates over
        // each level
        while (Q.size() > 0) {
            // Note the size of the queue
            int size = Q.size();
            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {
                // Pop a node from the front of the queue
                Node node = Q.poll();
                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) node.next = Q.peek();

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
        }
        // Since the tree has now been modified, return the root node
        return root;
    }
     */


    /* Approach 2: Using previously established next pointers
     public Node connect(Node root) {
        if (root == null) return root;

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;
        // Once we reach the final level, we are done
        while (leftmost.left != null) {
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            // Move onto the next level
            leftmost = leftmost.left;
        }
        return root;
    }
     */

}
