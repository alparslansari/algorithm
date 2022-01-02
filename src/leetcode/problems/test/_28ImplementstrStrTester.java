package leetcode.problems.test;

import leetcode.problems._28ImplementstrStr;
import leetcode.utilities.TesterHelper;

public class _28ImplementstrStrTester {
    public static void main(String[] args) {
        _28ImplementstrStr tester = new _28ImplementstrStr();
        TesterHelper helper = new TesterHelper();
        String haystack = "hello";
        String needle = "ll";
        int expected = 2;
        helper.check(expected,tester.strStr(haystack, needle));

        haystack = "aaaaaa";
        needle = "bba";
        expected = -1;
        helper.check(expected,tester.strStr(haystack, needle));

        haystack = "";
        needle = "";
        expected = 0;
        helper.check(expected,tester.strStr(haystack, needle));

        haystack = "a";
        needle = "a";
        expected = 0;
        helper.check(expected,tester.strStr(haystack, needle));

    }
}
