package leetcode.problems;

import java.util.HashMap;

/** 387. First Unique Character in a String
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 * Constraints:
 *     1 <= s.length <= 105
 *     s consists of only lowercase English letters.
 */
public class _387FirstUniqueCharacterInString {

    // Approach 1: Linear time solution
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears.
        for (int i = 0; i<n; i++)
        {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }

        // find the index
        for(int i=0;i<n;i++){
            if(count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    // My Solution
    public int firstUniqCharMine(String s) {
        int[] dic = new int[128];
        int[] ind = new int[128];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<128; i++)
        {
            dic[i] = 0;
            ind[i] = 0; // initialize
        }
        for(int i = 0; i<s.length(); i++)
        {
            if(dic[s.charAt(i)]==0)
            {
                sb.append(s.charAt(i));
                dic[s.charAt(i)]=1;
                ind[s.charAt(i)]=i;
            } else {
                dic[s.charAt(i)]+=1;
            }
        }
        String index = sb.toString();

        for(int i = 0; i<index.length();i++)
        {
            if(dic[index.charAt(i)]==1) return ind[index.charAt(i)];
        }
        return -1;
    }

}
