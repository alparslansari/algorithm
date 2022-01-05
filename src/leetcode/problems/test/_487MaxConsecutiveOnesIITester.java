package leetcode.problems.test;

import leetcode.problems._487MaxConsecutiveOnesII;
import leetcode.utilities.TesterHelper;

public class _487MaxConsecutiveOnesIITester {
    public static void main(String[] args) {
        _487MaxConsecutiveOnesII tester = new _487MaxConsecutiveOnesII();
        TesterHelper helper = new TesterHelper();

        int[] nums1 = {1,0,1,1,0};
        int expected = 4;
        helper.check(expected, tester.findMaxConsecutiveOnes(nums1));
        int[] nums2 = {1,0,1,1,0,1};
        expected = 4;
        helper.check(expected, tester.findMaxConsecutiveOnes(nums2));
    }
}
