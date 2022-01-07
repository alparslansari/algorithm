package leetcode.datastructures.singlylinkedlist;

/**
 * Design a generic singly linked list node
 * @param <T>
 */
public class SinglyListNode<T> {
    T val;
    SinglyListNode next;
    SinglyListNode(T ele) {
        this.val = ele;
    }
}
