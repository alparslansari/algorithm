package leetcode.problems;

import java.util.*;

/** 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 *     1 <= strs.length <= 10^4
 *     0 <= strs[i].length <= 100
 *     strs[i] consists of lowercase English letters.
 */
public class _49GroupAnagrams {

    /** Approach 1: Categorize by Sorted String
     * time complexity: O(N*K*logK)
     * space complexity O(N*K)
      */
    public List<List<String>> groupAnagramsV1(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    /** Approach 2: Categorize by Count
     * time complexity: O(N*K + N*A)
     * space complexity: O(N*K + N*A)
     */
    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s: strs){
            int[] count = new int[26];
            for(char c:s.toCharArray())
                count[c-'a']++;

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(count[i]);
                sb.append("#");
            }
            String key = sb.toString();
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
