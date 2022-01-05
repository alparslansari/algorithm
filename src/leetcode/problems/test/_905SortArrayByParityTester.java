package leetcode.problems.test;

import leetcode.problems._905SortArrayByParity;
import leetcode.utilities.TesterHelper;

public class _905SortArrayByParityTester {
    public static void main(String[] args) {
        _905SortArrayByParity tester = new _905SortArrayByParity();
        TesterHelper helper = new TesterHelper();

        int[] nums1 = {3,1,2,4};
        //int[] exp1 = {2,4,3,1};
        int[] exp1 = {2,4,1,3};
        helper.check(exp1, tester.sortArrayByParity(nums1));

        int[] nums2 = {0};
        int[] exp2 = {0};
        helper.check(exp2, tester.sortArrayByParity(nums2));

    }
}
