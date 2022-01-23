package leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** 346. Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *     MovingAverage(int size) Initializes the object with the size of the window size.
 *     double next(int val) Returns the moving average of the last size values of the stream.
 */
public class _346MovingAveragefromDataStream {
    // Approach 1: Array or List

}

/**
 * Approach 1: Array or List
 */
class MovingAverageArray {
    int size;
    List queue = new ArrayList<Integer>();
    public MovingAverageArray(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        // calculate the sum of the moving window
        int windowSum = 0;
        for(int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
            windowSum += (int)queue.get(i);
        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
}

/** Approach 2: Double-ended Queue
 *
 */
class MovingAverageDeque {
    int size, windowSum = 0, count = 0;
    Deque queue = new ArrayDeque<Integer>();

    public MovingAverageDeque(int size) {
        this.size = size;
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;
        windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}

/**
 * Approach 3: Circular Queue with Array
 */
class MovingAverage {
    int size, head = 0, windowSum = 0, count = 0;
    int[] queue;
    public MovingAverage(int size) {
        this.size = size;
        queue = new int[size];
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        int tail = (head + 1) % size;
        windowSum = windowSum - queue[tail] + val;
        // move on to the next head
        head = (head + 1) % size;
        queue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}