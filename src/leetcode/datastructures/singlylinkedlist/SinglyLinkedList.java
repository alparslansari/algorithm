package leetcode.datastructures.singlylinkedlist;

public class SinglyLinkedList<T> {
    SinglyListNode head = null;

    public SinglyLinkedList() { }

    public SinglyLinkedList(T ele) {
        SinglyListNode<T> node = new SinglyListNode<T>(ele);
        this.head = node;
    }

    public SinglyLinkedList(SinglyListNode head) {
        this.head = head;
    }

    public void addFirst(T ele)
    {
        SinglyListNode<T> node = new SinglyListNode<T>(ele);
        if(this.head == null) this.head = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(T ele)
    {
        SinglyListNode<T> node = new SinglyListNode<T>(ele);
        if(this.head == null) this.head = node;
        else {
            SinglyListNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
        }
    }

}
