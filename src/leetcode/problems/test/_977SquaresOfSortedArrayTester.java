package leetcode.problems.test;

import leetcode.problems._977SquaresOfSortedArray;
import leetcode.utilities.TesterHelper;

public class _977SquaresOfSortedArrayTester {
    public static void main(String[] args) {
        _977SquaresOfSortedArray tester = new _977SquaresOfSortedArray();
        TesterHelper helper = new TesterHelper();

        int[] nums1 = {-4,-1,0,3,10};
        int[] exp1 = {0,1,9,16,100};
        helper.check(exp1, tester.sortedSquares(nums1));

        int[] nums2 = {-7,-3,2,3,11};
        int[] exp2 = {4,9,9,49,121};
        helper.check(exp2, tester.sortedSquares(nums2));

    }
}
