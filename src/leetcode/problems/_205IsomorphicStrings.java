package leetcode.problems;

import java.util.Arrays;
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

    //Approach 2: First occurence transformation
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
    // Approach 1: Character Mapping with Dictionary (Faster)
    public boolean isIsomorphicSimple(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }

}
