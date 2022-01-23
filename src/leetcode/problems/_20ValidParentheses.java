package leetcode.problems;

import java.util.Map;
import java.util.Stack;

/** 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 *     1 <= s.length <= 10^4
 *     s consists of parentheses only '()[]{}'.
 */
public class _20ValidParentheses {
    /**
     * Time:  O(n)
     * Space: O(n)
     */
    private static final Map<Character, Character> map = Map.of('(',')','{','}','[',']');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char open = stack.pop();
                if(map.get(open) != c) return false;
            }
        }
        return stack.isEmpty(); // at this point stack should empty
    }
}
