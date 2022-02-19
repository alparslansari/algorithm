package leetcode.problems.linkedin;

/**
 * 341. Flatten Nested List Iterator
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
 * <p>
 * Implement the NestedIterator class:
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * <p>
 * Your code will be tested with the following pseudocode:
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * <p>
 * If res matches the expected flattened list, then your code will be judged as correct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * Example 2:
 * <p>
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-106, 106].
 */

import leetcode.models.NestedInteger;

import java.util.*;

public class _341FlattenNestedListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */


    public class NestedIterator implements Iterator<Integer> {

        // This time, our stack will hold list iterators instead of just lists.
        private final Deque<ListIterator<NestedInteger>> stackOfIterators = new ArrayDeque();
        private Integer peeked = null;

        public NestedIterator(List<NestedInteger> nestedList) {
            // Make an iterator with the input and put it on the stack.
            // Note that creating a list iterator is an O(1) operation.
            stackOfIterators.addFirst(nestedList.listIterator());
        }

        private void setPeeked() {

            // If peeked is already set, there's nothing to do.
            if (peeked != null) return;

            while (!stackOfIterators.isEmpty()) {

                // If the iterator at the top of the stack doesn't have a next,
                // remove that iterator and continue on.
                if (!stackOfIterators.peekFirst().hasNext()) {
                    stackOfIterators.removeFirst();
                    continue;
                }

                // Otherwise, we need to check whether that next is a list or
                // an integer.
                NestedInteger next = stackOfIterators.peekFirst().next();

                // If it's an integer, set peeked to it and return as we're done.
                if (next.isInteger()) {
                    peeked = next.getInteger();
                    return;
                }

                // Otherwise, it's a list. Create a new iterator with it, and put
                // the new iterator on the top of the stack.
                stackOfIterators.addFirst(next.getList().listIterator());
            }
        }


        @Override
        public Integer next() {

            // As per Java specs, throw an exception if there are no further elements.
            if (!hasNext()) throw new NoSuchElementException();

            // hasNext() called setPeeked(), which ensures peeked has the next integer
            // in it. We need to clear the peeked field so that the element is returned
            // again.
            Integer result = peeked;
            peeked = null;
            return result;
        }

        @Override
        public boolean hasNext() {

            // Try to set the peeked field. If any integers are remaining, it will
            // contain the next one to be returned after this call.
            setPeeked();

            // There are elements remaining iff peeked contains a value.
            return peeked != null;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
