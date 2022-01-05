package leetcode.problems.test;

import leetcode.problems._1051HeightChecker;
import leetcode.utilities.TesterHelper;

public class _1051HeightCheckerTester {
    public static void main(String[] args) {
        _1051HeightChecker tester = new _1051HeightChecker();
        TesterHelper helper = new TesterHelper();

        int[] h1 = {1,1,4,2,1,3};
        int exp = 3;
        helper.check(exp, tester.heightChecker(h1));

        int[] h2={5,1,2,3,4};
        exp = 5;
        helper.check(exp, tester.heightChecker(h2));

        int[] h3={1,2,3,4,5};
        exp = 0;
        helper.check(exp, tester.heightChecker(h3));


    }
}
