package leetcode.problems.linkedin;

/** 360. Sort Transformed Array
 * Given a sorted integer array nums and three integers a, b and c, apply a quadratic
 * function of the form f(x) = ax2 + bx + c to each element nums[i] in the array,
 * and return the array in a sorted order.
 *
 * Example 1:
 * Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * Output: [3,9,15,33]
 *
 * Example 2:
 * Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * Output: [-23,-5,1,7]
 *
 * Constraints:
 *     1 <= nums.length <= 200
 *     -100 <= nums[i], a, b, c <= 100
 *     nums is sorted in ascending order.
 */
public class _360SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return sorted;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
