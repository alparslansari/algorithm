package leetcode.problems.linkedin;

import java.util.HashMap;
import java.util.Stack;

/** 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
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
 */
public class _20ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // look for closing bracket
            if(map.containsKey(c)){
                char topEle = stack.empty() ? '.' : stack.pop();
                // check bracket match
                if(topEle != map.get(c)) return false;
            } else {
                // opening bracket, push
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
