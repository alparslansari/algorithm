package leetcode.problems.linkedin;

import java.util.HashMap;

/** 170. Two Sum III - Data structure design
 *  Design a data structure that accepts a stream of integers and checks if it has a pair of integers
 *  that sum up to a particular value.
 *
 * Implement the TwoSum class:
 *  TwoSum() Initializes the TwoSum object, with an empty array initially.
 *  void add(int number) Adds number to the data structure.
 *  boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value,
 *  otherwise, it returns false.
 * Example 1:
 * Input
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * Output
 * [null, null, null, null, true, false]
 *
 * Explanation
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4, return true
 * twoSum.find(7);  // No two integers sum up to 7, return false
 *
 * Constraints:
 *     -105 <= number <= 105
 *     -231 <= value <= 231 - 1
 *     At most 104 calls will be made to add and find.
 */
public class _170TwoSumIIIDataStructureDesign {
    class TwoSum {

        private HashMap<Integer, Integer> nums_count;

        /** Initialize your data structure here. */
        public TwoSum() {
            this.nums_count = new HashMap<Integer, Integer>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            this.nums_count.put(number, nums_count.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(Integer key : this.nums_count.keySet()) {
                int complement = value - key;
                if(complement != key) {
                    if(this.nums_count.containsKey(complement))
                        return true;
                } else if(this.nums_count.get(key) > 1)
                    return true;
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

}
