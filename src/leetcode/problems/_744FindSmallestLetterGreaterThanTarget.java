package leetcode.problems;

/** 744. Find Smallest Letter Greater Than Target
 *  Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
 *
 * Note that the letters wrap around.
 *     For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 * Example 1:
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 *
 * Example 2:
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 *
 * Example 3:
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 *
 *
 *
 * Constraints:
 *
 *     2 <= letters.length <= 10^4
 *     letters[i] is a lowercase English letter.
 *     letters is sorted in non-decreasing order.
 *     letters contains at least two different characters.
 *     target is a lowercase English letter.
 */
public class _744FindSmallestLetterGreaterThanTarget {
    /** Approach #1: Record Letters Seen [Accepted] */
    public char nextGreatestLetterV1(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }

    /** Approach #2: Linear Scan - fastest */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }

    /** Approach #3: Binary Search */
    public char nextGreatestLetterV2(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }
}
