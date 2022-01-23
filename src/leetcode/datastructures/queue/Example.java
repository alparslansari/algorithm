package leetcode.datastructures.queue;

public class Example {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) System.out.println(q.Front());
        q.deQueue();
        if (q.isEmpty() == false) System.out.println(q.Front());
        q.deQueue();
        if (q.isEmpty() == false) System.out.println(q.Front());
    }
}
