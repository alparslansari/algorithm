package leetcode.problems;

import leetcode.utilities.TesterHelper;

public class _344ReverseStringTester {
    public static void main(String[] args) {
        _344ReverseString tester = new _344ReverseString();
        TesterHelper helper = new TesterHelper();
        char[] test1 = {'h','e','l','l','o'};
        char[] expected1 = {'o','l','l','e','h'};
        tester.reverseString(test1);
        helper.check(expected1,test1);

        char[] test2 = {'H','a','n','n','a','h'};
        char[] expected2 = {'h','a','n','n','a','H'};
        tester.reverseString(test2);
        helper.check(expected2,test2);

        char[] test3 = {'a'};
        char[] expected3 = {'a'};
        tester.reverseString(test3);
        helper.check(expected3,test3);


    }
}
