package leetcode.problems.test;

import leetcode.problems._448FindAllNumbersDisappearedInAnArray;
import leetcode.utilities.Collections;
import leetcode.utilities.TesterHelper;

import java.util.List;

public class _448FindAllNumbersDisappearedInAnArrayTester {
    public static void main(String[] args) {
        _448FindAllNumbersDisappearedInAnArray tester = new _448FindAllNumbersDisappearedInAnArray();
        TesterHelper helper = new TesterHelper();
        Collections col = new Collections();
        int[] nums1 = {4,3,2,7,8,2,3,1};
        List<Integer> expected = col.asList(5,6);
        helper.check(expected.toArray(),tester.findDisappearedNumbers(nums1).toArray());

        int[] nums2 = {1,1};
        expected = col.asList(2);
        helper.check(expected.toArray(),tester.findDisappearedNumbers(nums2).toArray());


    }
}
