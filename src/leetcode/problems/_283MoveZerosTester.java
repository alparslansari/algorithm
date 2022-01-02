package leetcode.problems;

import leetcode.utilities.TesterHelper;

public class _283MoveZerosTester {
    public static void main(String[] args) {
        _283MoveZeros tester = new _283MoveZeros();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        tester.moveZeroes(nums1);
        helper.check(expected,nums1);


        int[] nums2 = {0};
        int[] expected2 = {0};
        tester.moveZeroes(nums2);
        helper.check(expected2,nums2);

    }
}
