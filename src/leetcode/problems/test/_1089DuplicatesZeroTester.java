package leetcode.problems.test;

import leetcode.problems._1089DuplicatesZero;
import leetcode.utilities.TesterHelper;

public class _1089DuplicatesZeroTester {
    public static void main(String[] args) {
        _1089DuplicatesZero tester = new _1089DuplicatesZero();
        TesterHelper helper = new TesterHelper();

        int[] arr1 = {1,0,2,3,0,4,5,0};
        int[] expected1 = {1,0,0,2,3,0,0,4};
        tester.duplicateZerosWithExraArray(arr1);
        helper.check(expected1, arr1);

        int[] arr2 = {1,2,3};
        int[] expected2 = {1,2,3};
        tester.duplicateZerosWithExraArray(arr2);
        helper.check(expected2, arr2);
    }
}
