package leetcode.problems.linkedin;

/** 796. Rotate String
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *  For example, if s = "abcde", then it will be "bcdea" after one shift.
 * Example 1:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 *
 * Example 2:
 * Input: s = "abcde", goal = "abced"
 * Output: false
 *
 * Constraints:
 *     1 <= s.length, goal.length <= 100
 *     s and goal consist of lowercase English letters.
 */
public class _796RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        return recursiveSolution(A, B, A.length());
    }

    private boolean recursiveSolution(String A, String B, int stop)
    {
        if(A.equals(B)) return true;
        if(stop==0) return false;
        A = A.substring(1,A.length()) + A.charAt(0);
        stop -= 1;
        return recursiveSolution(A, B, stop);
    }
}
