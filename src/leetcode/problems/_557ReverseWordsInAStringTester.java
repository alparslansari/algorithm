package leetcode.problems;

import leetcode.utilities.TesterHelper;

public class _557ReverseWordsInAStringTester {

    public static void main(String[] args) {
        _557ReverseWordsInAString tester = new _557ReverseWordsInAString();
        TesterHelper helper = new TesterHelper();

        String s = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        helper.check(expected,tester.reverseWords(s));

        s = "God Ding";
        expected = "doG gniD";
        helper.check(expected,tester.reverseWords(s));
    }
}
