package leetcode.problems;

import java.util.Arrays;

public class _66PlusOneTester {
    public static void main(String[] args) {
        _66PlusOne tester = new _66PlusOne();
        int test1[] = {1,2,3};
        int result1[] = {1,2,4};
        if(Arrays.equals(tester.plusOne(test1), result1)) System.out.println("Test 1 is passed");
        else System.out.println("Test 1 is failed");

        int test2[] = {4,3,2,1};
        int result2[] = {4,3,2,2};
        if(Arrays.equals(tester.plusOne(test2), result2)) System.out.println("Test 2 is passed");
        else System.out.println("Test 2 is failed");

        int test3[] = {9};
        int result3[] = {1,0};
        if(Arrays.equals(tester.plusOne(test3), result3)) System.out.println("Test 3 is passed");
        else System.out.println("Test 3 is failed");

        int test4[] = {9,9,9};
        int result4[] = {1,0,0,0};
        if(Arrays.equals(tester.plusOne(test4), result4)) System.out.println("Test 4 is passed");
        else System.out.println("Test 4 is failed");
    }
}
