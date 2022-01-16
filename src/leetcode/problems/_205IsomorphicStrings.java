package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/** 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Constraints:
 *     1 <= s.length <= 5 * 104
 *     t.length == s.length
 *     s and t consist of any valid ascii character.
 */
public class _205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    private String transformString(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            if(!idxMap.containsKey(c1))
                idxMap.put(c1,i);

            sb.append(Integer.toString(idxMap.get(c1)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
