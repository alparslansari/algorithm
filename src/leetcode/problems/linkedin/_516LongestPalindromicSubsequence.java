package leetcode.problems.linkedin;

/** 516. Longest Palindromic Subsequence
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence
 * by deleting some or no elements without changing the order of the remaining elements.
 *
 * Example 1:
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 * Constraints:
 *     1 <= s.length <= 1000
 *     s consists only of lowercase English letters.
 */
public class _516LongestPalindromicSubsequence {

    // Java DP 1-D array
    public int longestPalindromeSubseq(String s) {
        //dp[i][j] stores length of longest palindrome subsequence within index i and j
        //dp[i][j] can add on top of previous due to this is the length of subsequence not contiguous
        //if(s[i] == s[j]) dp[i][i] = 1, dp[i][i+1] = 2, dp[i+1][j-1]+2
        //if(s[i] != s[j]) dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1])\
        // 1-d array represents dp[i+1] array
        int[] dp = new int[s.length()];
        for(int i = s.length()-1; i>=0; i--) {
            int[] previousRow = new int[s.length()];
            previousRow[i] = 1;
            for(int j = i+1; j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j==i+1) previousRow[j] = 2;
                    else previousRow[j] = dp[j-1]+2;
                } else {
                    previousRow[j] = Math.max(dp[j],previousRow[j-1]);
                }
            }
            dp = previousRow;
        }
        return dp[s.length()-1];
    }
}
