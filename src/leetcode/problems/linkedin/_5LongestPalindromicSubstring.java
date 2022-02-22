package leetcode.problems.linkedin;

/** 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 *     1 <= s.length <= 1000
 *     s consist of only digits and English letters.
 *
 *     This approach works, it fails on leetcode as Time Limit Exceeded
 *     "babaddtattarrattatddetartrateedredividerb"
 */
public class _5LongestPalindromicSubstring {
    public int max = 0;
    public String palindrome = "";

    public String longestPalindrome(String s) {
        palindromeFinder(s);
        return palindrome;
    }

    private String palindromeFinder(String str){
        if(str.length() < max) return "";
        // check if the str is palindrome
        if(isPalindrome(str))
        {
            if(max<str.length())
            {
                max = str.length();
                palindrome = str;
            }
            return "";
        }
        // remove a char from begining
        palindromeFinder(str.substring(1, str.length()));
        // remove a char from end
        palindromeFinder(str.substring(0, str.length()-1));
        return "";
    }

    private boolean isPalindrome(String str)
    {
        int len = str.length();
        for(int i = 0; i < (len/2); i++)
            if(str.charAt(i) != str.charAt(len-i-1))
                return false;
        return true;
    }
}
