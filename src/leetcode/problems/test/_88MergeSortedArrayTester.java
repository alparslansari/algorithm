package leetcode.problems.test;

import leetcode.problems._88MergeSortedArray;
import leetcode.utilities.TesterHelper;

public class _88MergeSortedArrayTester {
    public static void main(String[] args) {
        _88MergeSortedArray tester = new _88MergeSortedArray();
        TesterHelper helper = new TesterHelper();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        int[] expected1 = {1,2,2,3,5,6};
        //tester.mergeAndSort(nums1,m,nums2,n);
        //tester.mergeWithPointers(nums1,m,nums2,n);
        tester.merge(nums1,m,nums2,n);
        helper.check(expected1,nums1);

        int[] nums3 = {1};
        int[] nums4 = {};
        m = 1;
        n = 0;
        int[] expected2 = {1};
        //tester.mergeAndSort(nums3,m,nums4,n);
        //tester.mergeWithPointers(nums3,m,nums4,n);
        tester.merge(nums3,m,nums4,n);
        helper.check(expected2,nums3);

        int[] nums5 = {0};
        int[] nums6 = {1};
        m = 0;
        n = 1;
        int[] expected3 = {1};
        //tester.mergeAndSort(nums5,m,nums6,n);
        // tester.mergeWithPointers(nums5,m,nums6,n);
        tester.merge(nums5,m,nums6,n);
        helper.check(expected3,nums5);
    }
}
