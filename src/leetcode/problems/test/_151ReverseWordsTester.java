package leetcode.problems.test;

import leetcode.problems._151ReverseWords;
import leetcode.utilities.TesterHelper;

public class _151ReverseWordsTester {
    public static void main(String[] args) {
        _151ReverseWords tester = new _151ReverseWords();
        TesterHelper helper = new TesterHelper();
        String s = "the sky is blue";
        String expected = "blue is sky the";
        helper.check(expected, tester.reverseWordsBuiltIn(s));
        helper.check(expected, tester.reverseWords(s));

        s = "  hello world  ";
        expected = "world hello";
        helper.check(expected, tester.reverseWordsBuiltIn(s));
        helper.check(expected, tester.reverseWords(s));

        s = "a good   example";
        expected = "example good a";
        helper.check(expected, tester.reverseWordsBuiltIn(s));
        helper.check(expected, tester.reverseWords(s));
    }
}
