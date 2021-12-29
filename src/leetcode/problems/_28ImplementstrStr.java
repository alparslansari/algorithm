package leetcode.problems;

/** 28. Implement strStr()
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 * Constraints:
 *     0 <= haystack.length, needle.length <= 5 * 104
 *     haystack and needle consist of only lower-case English characters.
 */
public class _28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        if(needle.length() == 0) return 0;
        int foundPosition = -1;
        for(int i=0;i<haystack.length();i++)
        {
            if(haystack.charAt(i)==needle.charAt(0) && haystack.length() - i >= needle.length())
            {
                // loop through needle if matching return start position
                boolean isMatched = true;
                for(int j=1;j<needle.length();j++)
                {
                    if(haystack.charAt(i+j)!=needle.charAt(j)) {
                        isMatched = false;
                        break;
                    }
                }
                if(isMatched) return i;
            }
        }

        return foundPosition;
    }
}
