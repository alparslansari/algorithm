package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 771. Jewels and Stones
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 *
 * Constraints:
 *     1 <= jewels.length, stones.length <= 50
 *     jewels and stones consist of only English letters.
 *     All the characters of jewels are unique.
 */
public class _771JewelsAndStones {
    // HashMap solution
    public int numJewelsInStonesHashMap(String jewels, String stones) {
        Map<Character, Boolean> jewelList = new HashMap<>();
        for(char c:jewels.toCharArray())
            jewelList.put(c,true);
        int result = 0;
        for(char c:stones.toCharArray())
            if(jewelList.containsKey(c)) result++;
        return result;
    }
    // HashSet solution
    public int numJewelsInStonesHashSet(String jewels, String stones) {
        Set<Character> jList = new HashSet<>();
        for(char j: jewels.toCharArray())
            jList.add(j);
        int result = 0;
        for(char s:stones.toCharArray())
            if(jList.contains(s)) result++;
        return result;
    }

}
