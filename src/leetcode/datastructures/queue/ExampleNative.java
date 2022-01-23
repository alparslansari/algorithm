package leetcode.datastructures.queue;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class ExampleNative {
    public static void main(String[] args) {
        // 1. Initialize a Queue
        Queue<Integer> q = new LinkedList<>();
        // 2. Get the first element - return null if the queue is empty.
        System.out.println("The first element is:" + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element
        System.out.println("The first element is: "+q.peek());
        //6. Get the size of the queue.
        System.out.println("The size is: "+q.size());
    }


}
