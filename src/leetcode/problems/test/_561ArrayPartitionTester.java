package leetcode.problems.test;

import leetcode.problems._561ArrayPartition;
import leetcode.utilities.TesterHelper;

public class _561ArrayPartitionTester {
    public static void main(String[] args) {
        _561ArrayPartition tester = new _561ArrayPartition();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {1,4,3,2};
        int expected = 4;
        helper.check(expected, tester.arrayPairSum(nums1));

        int[] nums2 = {6,2,6,5,1,2};
        expected = 9;
        helper.check(expected, tester.arrayPairSum(nums2));

    }
}
