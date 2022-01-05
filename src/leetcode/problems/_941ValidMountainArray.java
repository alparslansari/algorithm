package leetcode.problems;

/** 941. Valid Mountain Array
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 *     arr.length >= 3
 *     There exists some i with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 * Constraints:
 *     1 <= arr.length <= 10^4
 *     0 <= arr[i] <= 10^4
 */
public class _941ValidMountainArray {

    public boolean validMountainArray(int[] arr)
    {
        int N = arr.length;
        int i = 0;

        // walk up
        while(i+1 < N && arr[i] < arr[i+1]) i++;

        // peak can't be first or last
        if(i==0 || i ==N-1) return false;

        // walk down
        while(i+1 < N && arr[i] > arr[i+1]) i++;

        return i == N-1;
    }


    public boolean validMountainArraySlow(int[] arr) {
        if(arr == null || arr.length < 3) return false;
        boolean isIncreasing = arr[1] > arr[0];
        if(!isIncreasing) return false; // the mountain should start in an increasing manner.

        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] == arr[i-1]) return false; // plateaus are prohibitted.
            if(isIncreasing) {
                if(arr[i] < arr[i-1]) isIncreasing = false; // reach the peak
            } else {
                // every element must be decreasing, otherwise return false;
                if(arr[i] > arr[i-1]) return false;
            }
        }

        return !isIncreasing;
    }
}
