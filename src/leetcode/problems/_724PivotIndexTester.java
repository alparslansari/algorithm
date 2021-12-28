package leetcode.problems;

import java.util.Arrays;

public class _724PivotIndexTester {

    public static void main(String[] args) {
        _724PivotIndex tester = new _724PivotIndex();
        int[] nums1 = {1,7,3,6,5,6};
        if(tester.pivotIndex(nums1) != 3) System.out.println("Test case failed! nums1 ");

        int[] nums2 = {1,2,3};
        if(tester.pivotIndex(nums2) != -1) System.out.println("Test case failed! nums2 " + Arrays.asList(nums2).toString());

        int[] nums3 = {2,1,-1};
        if(tester.pivotIndex(nums3) != 0) System.out.println("Test case failed! nums3 " + Arrays.asList(nums3).toString());


    }

}
