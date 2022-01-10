package leetcode.problems;

import java.util.ArrayList;
import java.util.List;


/** 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome.
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 *     The number of nodes in the list is in the range [1, 10^5].
 *     0 <= Node.val <= 9
 * Follow up: Could you do it in O(n) time and O(1) space?
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while(currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while(front < back) {
            // Note that we must use ! . equals instead of !=
            // because we are comparing Integer, not int.
            if(!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    // Recursive solution.
        private ListNode frontPointer;

        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {
                if (!recursivelyCheck(currentNode.next)) return false;
                if (currentNode.val != frontPointer.val) return false;
                frontPointer = frontPointer.next;
            }
            return true;
        }

        private boolean isPalindromeRecursive(ListNode head) {
            frontPointer = head;
            return recursivelyCheck(head);
        }
}
