package leetcode.problems.test;

import leetcode.problems._485MaxConsecutive;
import leetcode.utilities.TesterHelper;

public class _485MaxConsecutiveTester {
    public static void main(String[] args) {
        _485MaxConsecutive tester = new _485MaxConsecutive();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {1,1,0,1,1,1};
        int expected = 3;
        helper.check(expected, tester.findMaxConsecutiveOnes(nums1));

        int[] nums2 = {1,0,1,1,0,1};
        expected = 2;
        helper.check(expected, tester.findMaxConsecutiveOnes(nums2));
    }
}
