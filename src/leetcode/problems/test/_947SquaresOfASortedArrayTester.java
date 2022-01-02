package leetcode.problems.test;

import leetcode.problems._947SquaresOfASortedArray;
import leetcode.utilities.TesterHelper;

public class _947SquaresOfASortedArrayTester {
    public static void main(String[] args) {
        _947SquaresOfASortedArray tester = new _947SquaresOfASortedArray();
        TesterHelper helper = new TesterHelper();

        int[] nums1 = {-4,-1,0,3,10};
        int[] expected1 = {0,1,9,16,100};
        helper.check(expected1,tester.sortedSquares(nums1));

        int[] nums2 = {-7,-3,2,3,11};
        int[] expected2 = {4,9,9,49,121};
        helper.check(expected2,tester.sortedSquares(nums2));
    }
}
