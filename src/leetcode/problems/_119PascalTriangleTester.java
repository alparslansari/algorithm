package leetcode.problems;

import leetcode.utilities.Collections;
import leetcode.utilities.TesterHelper;

import java.util.List;

public class _119PascalTriangleTester {
    public static void main(String[] args) {
        _119PascalTriangle tester = new _119PascalTriangle();
        TesterHelper helper = new TesterHelper();
        Collections col = new Collections();

        int rowIndex = 3;
        List<Integer> expected = col.asList(1,3,3,1);
        helper.check(expected.toArray(),tester.getRowDP(rowIndex).toArray());
        helper.check(expected.toArray(),tester.getRow(rowIndex).toArray());

        rowIndex = 0;
        expected = col.asList(1);
        helper.check(expected.toArray(),tester.getRowDP(rowIndex).toArray());
        helper.check(expected.toArray(),tester.getRow(rowIndex).toArray());

        rowIndex = 1;
        expected = col.asList(1, 1);
        helper.check(expected.toArray(),tester.getRowDP(rowIndex).toArray());
        helper.check(expected.toArray(),tester.getRow(rowIndex).toArray());

        rowIndex = 4;
        expected = col.asList(1,4,6,4,1);
        helper.check(expected.toArray(),tester.getRowDP(rowIndex).toArray());
        helper.check(expected.toArray(),tester.getRow(rowIndex).toArray());



    }
}
