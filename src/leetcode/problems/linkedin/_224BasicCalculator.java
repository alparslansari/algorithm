package leetcode.problems.linkedin;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as
 * mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 * <p>
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * <p>
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * <p>
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class _224BasicCalculator {
    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<Integer>();
            int operand = 0;
            int result = 0; // For the on-going result
            int sign = 1;  // 1 means positive, -1 means negative

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    // Forming operand, since it could be more than one digit
                    operand = 10 * operand + (ch - '0');
                } else if (ch == '+') {
                    // Evaluate the expression to the left,
                    // with result, sign, operand
                    result += sign * operand;
                    // Save the recently encountered '+' sign
                    sign = 1;
                    // Reset operand
                    operand = 0;
                } else if (ch == '-') {
                    result += sign * operand;
                    sign = -1;
                    operand = 0;
                } else if (ch == '(') {
                    // Push the result and sign on to the stack, for later
                    // We push the result first, then sign
                    stack.push(result);
                    stack.push(sign);
                    // Reset operand and result, as if new evaluation begins for the new sub-expression
                    sign = 1;
                    result = 0;
                } else if (ch == ')') {
                    // Evaluate the expression to the left
                    // with result, sign and operand
                    result += sign * operand;
                    // ')' marks end of expression within a set of parenthesis
                    // Its result is multiplied with sign on top of stack
                    // as stack.pop() is the sign before the parenthesis
                    result *= stack.pop();
                    // Then add to the next operand on the top.
                    // as stack.pop() is the result calculated before this parenthesis
                    // (operand on stack) + (sign on stack * (result from parenthesis))
                    result += stack.pop();
                    // Reset the operand
                    operand = 0;
                }
            }
            return result + (sign * operand);
        }
    }
}
