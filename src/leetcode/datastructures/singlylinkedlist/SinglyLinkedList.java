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
        node.next = head;
        head = node;
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

    /** Helper function to return the index-th node in the linked list. */
    private SinglyListNode getNode(int index) {
        SinglyListNode cur = head;
        for (int i = 0; i < index && cur != null; ++i) {
            cur = cur.next;
        }
        return cur;
    }
    /** Helper function to return the last node in the linked list. */
    private SinglyListNode getTail() {
        SinglyListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SinglyListNode cur = new SinglyListNode(val);
        cur.next = head;
        head = cur;
        return;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        SinglyListNode prev = getTail();
        SinglyListNode cur = new SinglyListNode(val);
        prev.next = cur;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        SinglyListNode prev = getNode(index - 1);
        if (prev == null) {
            return;
        }
        SinglyListNode cur = new SinglyListNode(val);
        SinglyListNode next = prev.next;
        cur.next = next;
        prev.next = cur;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        SinglyListNode cur = getNode(index);
        if (cur == null) {
            return;
        }
        SinglyListNode next = cur.next;
        if (index == 0) {
            // modify head when deleting the first node.
            head = next;
        } else {
            SinglyListNode prev = getNode(index - 1);
            prev.next = next;
        }
    }


}
