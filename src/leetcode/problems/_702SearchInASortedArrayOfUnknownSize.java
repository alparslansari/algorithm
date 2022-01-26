package leetcode.problems;

/** 702. Search in a Sorted Array of Unknown Size
 * This is an interactive problem.
 *
 * You have a sorted array of unique elements and an unknown size.
 * You do not have an access to the array but you can use the ArrayReader interface to access it.
 * You can call ArrayReader.get(i) that:
 *     returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
 *     returns 2^31 - 1 if the i is out of the boundary of the array.
 * You are also given an integer target.
 *
 * Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: secret = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in secret and its index is 4.
 *
 * Example 2:
 * Input: secret = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in secret so return -1.
 *
 * Constraints:
 *     1 <= secret.length <= 104
 *     -104 <= secret[i], target <= 104
 *     secret is sorted in a strictly increasing order.
 */
// to be provided by leetcode
class ArrayReader {
    public int get(int i) { return i;}
}

public class _702SearchInASortedArrayOfUnknownSize {

    public int search(ArrayReader reader, int target) {
        return mySearch(reader,target);
    }

    /* The Key here is figure out the easiest way to set our Boundary */
    public int mySearch(ArrayReader reader, int target) {

        int left = 0 , right = target-reader.get(0);
		 /*  Why right = target - reader.get(0) ?
		Explanation: Given all the elements in the Array are unique. If first value is n and we have all possible integers from n to target .
		We will find the target at worst case  at (target - n)
		Example: If First Element is -1 and target = 5 if the array had all elements between -1 and 5 i.e.,
		[-1,0,1,2,3,4,5] Worst case 5 will be at (target - firstValue)
		*/

        if(reader.get(right) == target)
            return right;

        while(left <= right){
            int mid = left+(right-left)/2;
            if(reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                left = mid+1;
            else
                right = mid - 1;
        }

        return -1;
    }

    /** Approach 1: Binary Search */
    public int searchV2(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        // search boundaries
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        // binary search
        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);

            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }

        // there is no target element
        return -1;
    }

}
