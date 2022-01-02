package leetcode.problems.test;

import leetcode.problems._1295FindNumbersWithEvenNumberOfDigits;
import leetcode.utilities.TesterHelper;

public class _1295FindNumbersWithEvenNumberOfDigitsTester {
    public static void main(String[] args) {
        _1295FindNumbersWithEvenNumberOfDigits tester = new _1295FindNumbersWithEvenNumberOfDigits();
        TesterHelper helper = new TesterHelper();

        int[] nums1 = {12,345,2,6,7896};
        int expected = 2;
        helper.check(expected,tester.findNumbers(nums1));

        int[] nums2 = {555,901,482,1771};
        expected = 1;
        helper.check(expected,tester.findNumbers(nums2));
    }
}
