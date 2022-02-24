package leetcode.problems.linkedin;

/** 245. Shortest Word Distance III
 * Given an array of strings wordsDict and two strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.
 *
 * Example 1:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Example 2:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
 * Output: 3
 *
 * Constraints:
 *     1 <= wordsDict.length <= 105
 *     1 <= wordsDict[i].length <= 10
 *     wordsDict[i] consists of lowercase English letters.
 *     word1 and word2 are in wordsDict.
 */
public class _245ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
}
