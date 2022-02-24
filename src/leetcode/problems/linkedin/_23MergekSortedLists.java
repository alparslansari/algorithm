package leetcode.problems.linkedin;

import leetcode.models.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * Input: lists = []
 * Output: []
 * <p>
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 */
public class _23MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                q.add(next);
            }
        }
        return head.next;
    }

}
