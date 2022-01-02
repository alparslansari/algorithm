package leetcode.problems;

import leetcode.utilities.TesterHelper;

public class _209MinimumSizeSubarraySumTester {
    public static void main(String[] args) {
        _209MinimumSizeSubarraySum tester = new _209MinimumSizeSubarraySum();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {2,3,1,2,4,3};
        int target = 7;
        int expected = 2;
        helper.check(expected, tester.minSubArrayLen(target, nums1));

        int[] nums2 = {1,4,4};
        target = 4;
        expected = 1;
        helper.check(expected, tester.minSubArrayLen(target, nums2));

        int[] nums3 = {1,1,1,1,1,1,1,1};
        target = 11;
        expected = 0;
        helper.check(expected, tester.minSubArrayLen(target, nums3));

    }
}
