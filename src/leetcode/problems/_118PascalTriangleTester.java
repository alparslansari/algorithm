package leetcode.problems;

import leetcode.utilities.Collections;

import java.util.ArrayList;
import java.util.List;

public class _118PascalTriangleTester {
    public static void main(String[] args) {
        _118PascalTriangle tester = new _118PascalTriangle();
        Collections col = new Collections();
        int test1 = 5;
        List<List<Integer>> expected1 = col.asList(
                col.asList(1),
                col.asList(1,1),
                col.asList(1,2,1),
                col.asList(1,3,3,1),
                col.asList(1,4,6,4,1));
        List<List<Integer>> result1 = tester.generatePascalTriangle(test1);
        if(expected1.equals(result1))
            System.out.println("Test1 is passed.");
        else
            System.out.println("Test1 is failed!");

        int test2 = 1;
        List<List<Integer>> expected2 = col.asList(
                col.asList(1));
        List<List<Integer>> result2 = tester.generatePascalTriangle(test2);
        if(expected2.equals(result2))
            System.out.println("Test1 is passed.");
        else
            System.out.println("Test1 is failed!");


    }
}
