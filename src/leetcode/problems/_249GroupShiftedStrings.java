package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 249. Group Shifted Strings
 * We can shift a string by shifting each of its letters to its successive letter.
 *     For example, "abc" can be shifted to be "bcd".
 * We can keep shifting the string to form a sequence.
 *     For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.
 *
 * Example 1:
 * Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
 * Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
 *
 * Example 2:
 * Input: strings = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 *     1 <= strings.length <= 200
 *     1 <= strings[i].length <= 50
 *     strings[i] consists of lowercase English letters.
 */
public class _249GroupShiftedStrings {

    /**
     * Approach 1: Hashing
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();
        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["abc"] = ["abc","bcd"]
        for(String str:strings){
            String hashKey = getHash(str);
            mapHashToList.putIfAbsent(hashKey, new ArrayList<>());
            mapHashToList.get(hashKey).add(str);
        }
        // Iterate over the map, and add the valuess to groups
        List<List<String>> groups = new ArrayList<>();
        for(List<String> group:mapHashToList.values())
            groups.add(group);
        return groups;
    }

    String getHash(String s) {
        char[] chars = s.toCharArray();
        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for(int i=0;i<chars.length;i++)
            chars[i] = shiftLetter(chars[i],shift);
        String hashKey = String.valueOf(chars);
        return hashKey;
    }

    char shiftLetter(char letter, int shift){
        return (char) ((letter - shift + 26) % 26 + 'a');
    }
    // -------------------------------------------------------------------------------
}
