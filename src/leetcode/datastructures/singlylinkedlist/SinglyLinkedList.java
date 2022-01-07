package leetcode.datastructures.singlylinkedlist;

public class SinglyLinkedList<T> {
    SinglyListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public SinglyLinkedList(T ele) {
        SinglyListNode<T> node = new SinglyListNode<T>(ele);
        this.head = node;
    }

    public SinglyLinkedList(SinglyListNode node) {
        this.head = node;
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
    public void removeFirst(){
        if(head != null) head = head.next;
    }

    public void removeLast()
    {

    }

    public T get(int index){
        SinglyListNode curr = head;
        for(int i = 0; i< index && curr != null; i++)
            curr = curr.next;
        if (curr == null) return null;
        return (T) curr.val;
    }

    public T getLast(){
        SinglyListNode curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }
        if (curr == null) return null;
        return (T) curr.val;
    }

}
