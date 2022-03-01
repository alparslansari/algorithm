package leetcode.problems;

/** 680. Valid Palindrome II
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Example 1:
 * Input: s = "aba"
 * Output: true
 *
 * Example 2:
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 *
 * Example 3:
 * Input: s = "abc"
 * Output: false
 *
 *
 *
 * Constraints:
 *     1 <= s.length <= 105
 *     s consists of lowercase English letters.
 */
public class _680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    /* Check is s[i...j] is palindrome. */
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    /** *****************************************************************************/
    public boolean validPalindromeMine(String s) {
        char[] str = s.toCharArray();
        if(isPalindrome(str, s, -1)) return true;
        for(int i=0;i<s.length();i++)
            if(isPalindrome(str, s, i)) return true;

        return false;
    }

    private boolean isPalindrome(char[] str, String s, int ignore)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            if(i!=ignore) sb.append(str[i]);
        if(sb.toString().equals(sb.reverse().toString())) return true;
        return false;
    }
}
