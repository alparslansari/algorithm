package leetcode.problems;
/** 24. Swap Nodes in Pairs
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *  You must solve the problem without modifying the values in the list's
 *  nodes (i.e., only nodes themselves may be changed.)
 */
public class _24SwapNodesInPairs {
    // Approach 1: Recursive Approach
    public ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }
        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        // Now the head is the second node
        return secondNode;
    }

    // Approach 2: Iterative Approach
    public ListNode swapPairsIterative(ListNode head) {
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while ((head != null) && (head.next != null)) {
            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }
        // Return the new head node.
        return dummy.next;
    }
}
