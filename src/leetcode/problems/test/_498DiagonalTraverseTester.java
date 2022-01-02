package leetcode.problems.test;

import leetcode.problems._498DiagonalTraverse;

import java.util.Arrays;

public class _498DiagonalTraverseTester {
    public static void main(String[] args) {
        _498DiagonalTraverse tester = new _498DiagonalTraverse();

        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result1 = {1,2,4,7,5,3,6,8,9};
        if(Arrays.equals(result1,tester.findDiagonalOrder(test1)))
            System.out.println("Test1 is passed.");
        else
            System.out.println("Test1 is failed!");


        int[][] test2 = {{1,2},{3,4}};
        int[] result2 = {1,2,3,4};
        if(Arrays.equals(result2,tester.findDiagonalOrder(test2)))
            System.out.println("Test2 is passed.");
        else
            System.out.println("Test2 is failed!");


    }
}
