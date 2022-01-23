package leetcode.datastructures;

import leetcode.models.Node;

import java.util.Queue;

public class BFSTemplate {
    /**
     * Return the length of the shortest path between root and target node.
     */
    int BFS(Node root, Node target) {
        Queue<Node> queue = null;  // store all nodes which are waiting to be processed
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
//        add root to queue;
        // BFS
        while (!queue.isEmpty()) { //queue is not empty
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
            //    Node cur = the first node in queue;
            //    return step if cur is target;
            //    for (Node next : the neighbors of cur) {
            //        add next to queue;
            //    }
            //    remove the first node from queue;
            }
            step = step + 1;
        }
        return -1;          // there is no path from root to target
    }
}

    /** Template 2
     * Return the length of the shortest path between root and target node.
     */
    /**
    int BFS(Node root, Node target) {
        Queue<Node> queue;  // store all nodes which are waiting to be processed
        Set<Node> visited;  // store all the nodes that we've visited
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        add root to queue;
        add root to visited;
        // BFS
        while (queue is not empty) {
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = the first node in queue;
                return step if cur is target;
                for (Node next : the neighbors of cur) {
                    if (next is not in visited) {
                        add next to queue;
                        add next to visited;
                    }
                }
                remove the first node from queue;
            }
            step = step + 1;
        }
        return -1;          // there is no path from root to target
    }
    */

    /**
     * See 286
     */