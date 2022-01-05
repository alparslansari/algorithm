package leetcode.problems.test;

import leetcode.problems._414ThirdMaximumNumber;
import leetcode.utilities.TesterHelper;

public class _414ThirdMaximumNumberTester {
    public static void main(String[] args) {
        _414ThirdMaximumNumber tester = new _414ThirdMaximumNumber();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {3,2,1};
        int expected = 1;
        helper.check(expected,tester.thirdMaxSet(nums1));

        int[] nums2 = {1,2};
        expected = 2;
        helper.check(expected,tester.thirdMaxSet(nums2));

        int[] nums3 = {2,2,3,1};
        expected = 1;
        helper.check(expected,tester.thirdMaxSet(nums3));


    }
}
