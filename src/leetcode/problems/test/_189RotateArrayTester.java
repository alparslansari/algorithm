package leetcode.problems;

import leetcode.utilities.TesterHelper;

public class _189RotateArrayTester {
    public static void main(String[] args) {
        _189RotateArray tester = new _189RotateArray();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {1,2,3,4,5,6,7};
        int kSteps = 3;
        int[] expected1 = {5,6,7,1,2,3,4};
        tester.rotate(nums1,kSteps);
        helper.check(expected1,nums1);

        int[] nums2 = {-1,-100,3,99};
        kSteps = 2;
        int[] expected2 = {3,99,-1,-100};
        tester.rotate(nums2,kSteps);
        helper.check(expected2,nums2);
    }
}
