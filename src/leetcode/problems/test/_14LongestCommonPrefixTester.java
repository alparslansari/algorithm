package leetcode.problems.test;

import leetcode.problems._14LongestCommonPrefix;
import leetcode.utilities.TesterHelper;

public class _14LongestCommonPrefixTester {
    public static void main(String[] args) {
        _14LongestCommonPrefix tester = new _14LongestCommonPrefix();
        TesterHelper helper = new TesterHelper();
        String[] strs = {"flower","flow","flight"};
        String expected = "fl";
        helper.check(expected,tester.longestCommonPrefixByHorizontalScan(strs));

        String[] strs1 = {"dog","racecar","car"};
        expected = "";
        helper.check(expected,tester.longestCommonPrefixByHorizontalScan(strs1));

    }
}
