package leetcode.array;

import java.util.Arrays;

public class TwoPointer {
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
            swap(v,i,j);
            i++;
            j--;
        }
    }

    public static void reverse(int[] v){
        int i = 0;
        int j = v.length - 1;
        while (i<j) {
            swap(v,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
