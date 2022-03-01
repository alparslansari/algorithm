package leetcode.problems.linkedin;

/** 1312. Minimum Insertion Steps to Make a String Palindrome
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 * Example 1:
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 *
 * Example 2:
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 *
 * Example 3:
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 *
 * Constraints:
 *     1 <= s.length <= 500
 *     s consists of lowercase English letters.
 */
public class _1312MinimumInsertionStepsToMakeAStringPalindrome {

    int[][] dp;

    public int minInsertions(String s) {
        dp = new int[501][501];
        return s.length() - longestPalindromeSubseq(s.toCharArray());
    }


    private int longestPalindromeSubseq(char[] s) {
        for (int len = 1; len <= s.length; ++len)
            for (int i = 0; i + len <= s.length; ++i)
                dp[i][i + len] = s[i] == s[i + len - 1] ? dp[i + 1][i + len - 1] + (len == 1 ? 1 : 2)
                        : Math.max(dp[i][i + len - 1], dp[i + 1][i + len]);
        return dp[0][s.length];
    }

}
