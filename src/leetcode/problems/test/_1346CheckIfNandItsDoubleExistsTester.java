package leetcode.problems.test;

import leetcode.problems._1346CheckIfNandItsDoubleExists;
import leetcode.utilities.TesterHelper;

public class _1346CheckIfNandItsDoubleExistsTester {
    public static void main(String[] args) {
        _1346CheckIfNandItsDoubleExists tester = new _1346CheckIfNandItsDoubleExists();
        TesterHelper helper = new TesterHelper();
        int[] arr1 = {10, 2, 5, 3};
        boolean expected = true;
        helper.check(expected, tester.checkIfExist(arr1));

        int[] arr2 = {7,1,14,11};
        expected = true;
        helper.check(expected, tester.checkIfExist(arr2));

        int[] arr3 = {3,1,7,11};
        expected = false;
        helper.check(expected, tester.checkIfExist(arr3));



    }
}
