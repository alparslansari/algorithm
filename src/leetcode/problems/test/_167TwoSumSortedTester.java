package leetcode.problems.test;

import leetcode.problems._167TwoSumSorted;
import leetcode.utilities.TesterHelper;

public class _167TwoSumSortedTester {
    public static void main(String[] args) {
        _167TwoSumSorted tester = new _167TwoSumSorted();
        TesterHelper helper = new TesterHelper();
        int[] num1 = {2,7,11,15};
        int[] exp1 = {1,2};
        helper.check(exp1,tester.twoSum(num1,9));

        int[] num2 = {2,3,4};
        int[] exp2 = {1,3};
        helper.check(exp2,tester.twoSum(num2,6));

        int[] num3 = {-1,0};
        int[] exp3 = {1,2};
        helper.check(exp3,tester.twoSum(num3,-1));

    }
}
