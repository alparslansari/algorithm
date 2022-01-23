package leetcode.recursion;

/**
 * Principle of Recursion:
 * Recursion is an approach to solving problems using a function that
 * calls itself as a subroutine.
 *
 * Each time a recursive function calls itself, it reduces the given problem
 * into subproblems. The recursion call continues until it reaches a point
 * where the subproblem can be solved without further recursion.
 *
 * A recursive function should have the following properties so that
 * it does not result in an infinite loop:
 *
 * A simple base case (or cases) — a terminating scenario that does not use
 * recursion to produce an answer.
 *  1- A set of rules, also known as recurrence relation that reduces all other
 *  cases towards the base case.
 *  2- Note that there could be multiple places where the function may call itself.
 */
public class ReadMe {

    /** Print a string in reverse order. */
    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }

}


