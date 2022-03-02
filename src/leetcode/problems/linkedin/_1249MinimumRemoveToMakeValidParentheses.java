package leetcode.problems.linkedin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/** 1249. Minimum Remove to Make Valid Parentheses
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *     It is the empty string, contains only lowercase characters, or
 *     It can be written as AB (A concatenated with B), where A and B are valid strings, or
 *     It can be written as (A), where A is a valid string.
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 *
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 * Constraints:
 *     1 <= s.length <= 105
 *     s[i] is either'(' , ')', or lowercase English letter.
 */
public class _1249MinimumRemoveToMakeValidParentheses {

    /** Approach 1: Using a Stack and String Builder */
    class Solution {
        public String minRemoveToMakeValid(String s) {
            Set<Integer> indexesToRemove = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        indexesToRemove.add(i);
                    } else {
                        stack.pop();
                    }
                }
            }
            // Put any indexes remaining on stack into the set.
            while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!indexesToRemove.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }


    /** Approach 3: Shortened Two Pass String Builder */
    class Solution3 {

        public String minRemoveToMakeValid(String s) {

            // Pass 1: Remove all invalid ")"
            StringBuilder sb = new StringBuilder();
            int openSeen = 0;
            int balance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    openSeen++;
                    balance++;
                } if (c == ')') {
                    if (balance == 0) continue;
                    balance--;
                }
                sb.append(c);
            }

            // Pass 2: Remove the rightmost "("
            StringBuilder result = new StringBuilder();
            int openToKeep = openSeen - balance;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '(') {
                    openToKeep--;
                    if (openToKeep < 0) continue;
                }
                result.append(c);
            }

            return result.toString();
        }
    }
}
