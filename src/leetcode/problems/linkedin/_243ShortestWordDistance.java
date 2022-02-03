package leetcode.problems.linkedin;

/** 243. Shortest Word Distance
 * Given an array of strings wordsDict and two different strings that
 * already exist in the array word1 and word2, return the shortest
 * distance between these two words in the list.
 *
 * Example 1:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"],
 * word1 = "coding", word2 = "practice"
 * Output: 3
 *
 * Example 2:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"],
 * word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Constraints:
 *     1 <= wordsDict.length <= 3 * 104
 *     1 <= wordsDict[i].length <= 10
 *     wordsDict[i] consists of lowercase English letters.
 *     word1 and word2 are in wordsDict.
 *     word1 != word2
 */
public class _243ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1, minDistance = words.length;
        for(int i=0;i<words.length;i++)
        {
            if(words[i].equals(word1)) pos1 = i;
            else if(words[i].equals(word2)) pos2 = i;
            if(pos1 != -1 && pos2 != -1)
                minDistance = Math.min(minDistance, Math.abs(pos1-pos2));
        }
        return minDistance;
    }
}
