package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/** 1089. Duplicate Zeros
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * Constraints:
 *     1 <= arr.length <= 10^4
 *     0 <= arr[i] <= 9
 */
public class _1089DuplicatesZero {

    public void duplicateZerosWithList(int[] arr) {
        List<Integer> sol = new ArrayList<>();
        int limit = arr.length;
        for(int i = 0;i<limit;i++)
        {
            if(arr[i] != 0) sol.add(arr[i]);
            else {
                sol.add(arr[i]);
                sol.add(0);
                limit -= 1;
            }
        }
        for(int i = 0;i<arr.length;i++)
            arr[i] = sol.get(i);
    }

    public void duplicateZerosWithExraArray(int[] arr) {
        int limit = arr.length;
        int[] sol = new int[limit];
        int solInd = 0;
        for(int i = 0;i<limit;i++)
        {
            if(arr[i] != 0)
            {
                sol[solInd] = arr[i];
            }
            else {
                sol[solInd] = arr[i];
                solInd++;
                if(solInd < sol.length) sol[solInd] = 0;
                limit -= 1;
            }
            solInd++;
        }
        for(int i = 0;i<arr.length;i++) arr[i] = sol[i];
    }
}
