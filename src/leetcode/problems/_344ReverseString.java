package leetcode.problems;

/** 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 *     1 <= s.length <= 105
 *     s[i] is a printable ascii character.
 */
public class _344ReverseString {

    public void reverseString(char[] s)
    {
        int start = 0;
        int end = s.length-1;
        char c;
        while(start<=end)
        {
            c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    public void reverseStringRecursive(char[] s)
    {
        helper(s, 0, s.length-1);
    }

    private void helper(char[] s, int left, int right) {
        if(left>=right) return; // Base condition
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left,right);
    }


}
