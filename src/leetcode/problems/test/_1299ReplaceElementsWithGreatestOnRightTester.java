package leetcode.problems.test;

import leetcode.problems._1299ReplaceElementsWithGreatestOnRight;
import leetcode.utilities.TesterHelper;

public class _1299ReplaceElementsWithGreatestOnRightTester {
    public static void main(String[] args) {
        _1299ReplaceElementsWithGreatestOnRight tester = new _1299ReplaceElementsWithGreatestOnRight();
        TesterHelper helper = new TesterHelper();

        int[] arr1 = {17,18,5,4,6,1};
        int[] exp1 = {18,6,6,6,1,-1};
        tester.replaceElements(arr1);
        helper.check(arr1,exp1);

        int[] arr2 = {400};
        int[] exp2 = {-1};
        tester.replaceElements(arr2);
        helper.check(arr2,exp2);

    }
}
