package leetcode.problems.linkedin;

/** 678. Valid Parenthesis String
 *  Given a string s containing only three types of characters:
 *  '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 *
 * Example 3:
 * Input: s = "(*))"
 * Output: true
 *
 * Constraints:
 *     1 <= s.length <= 100
 *     s[i] is '(', ')' or '*'.
 */
public class _678ValidParenthesisString {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for(char c: s.toCharArray()){
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if(hi<0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public boolean checkValidStringV2(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
