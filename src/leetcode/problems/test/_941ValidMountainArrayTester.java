package leetcode.problems.test;

import leetcode.problems._941ValidMountainArray;
import leetcode.utilities.TesterHelper;

public class _941ValidMountainArrayTester {
    public static void main(String[] args) {
        _941ValidMountainArray tester = new _941ValidMountainArray();
        TesterHelper helper = new TesterHelper();

        int[] arr1 = {2,1};
        boolean expected = false;
        helper.check(expected, tester.validMountainArray(arr1));

        int[] arr2 = {3,5,5};
        expected = false;
        helper.check(expected, tester.validMountainArray(arr2));

        int[] arr3 = {0,3,2,1};
        expected = true;
        helper.check(expected, tester.validMountainArray(arr3));
    }
}
