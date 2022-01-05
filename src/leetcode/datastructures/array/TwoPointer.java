package leetcode.datastructures.array;

import leetcode.utilities.Collections;

import java.util.Arrays;

public class TwoPointer {

    static Collections col = new Collections();

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(test));
        reverse(test);
        System.out.println(Arrays.toString(test));
    }

    public static void reverse(int[] v, int N){
        int i = 0;
        int j = N - 1;
        while (i<j) {
            col.swap(v,i,j);
            i++;
            j--;
        }
    }

    public static void reverse(int[] v){
        int i = 0;
        int j = v.length - 1;
        while (i<j) {
            col.swap(v,i,j);
            i++;
            j--;
        }
    }
}
