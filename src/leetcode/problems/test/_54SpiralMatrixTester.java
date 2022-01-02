package leetcode.problems.test;

import leetcode.problems._54SpiralMatrix;
import leetcode.utilities.Compare;

import java.util.Arrays;
import java.util.List;

// 54. Spiral Matrix
public class _54SpiralMatrixTester {
    public static void main(String[] args) {
        _54SpiralMatrix tester = new _54SpiralMatrix();
        Compare compare = new Compare();
        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[] expected1 = {1,2,3,6,9,8,7,4,5};
        List<Integer> result = tester.spiralOrder(test1);

        if(compare.compareIntArrayWithList(expected1, result))
            System.out.println("Test1 is passed.");
        else
            System.out.println("Test1 is failed!");


        int[][] test2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] expected2 = {1,2,3,4,8,12,11,10,9,5,6,7};
        result = tester.spiralOrder(test2);

        if(compare.compareIntArrayWithList(expected2, result))
            System.out.println("Test1 is passed.");
        else
            System.out.println("Test1 is failed!");

    }


}
