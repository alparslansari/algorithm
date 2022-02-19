package leetcode.problems.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244. Shortest Word Distance II
 * Design a data structure that will be initialized with a string array, and then
 * it should answer queries of the shortest distance between two different strings from the array.
 * <p>
 * Implement the WordDistance class:
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance
 * between word1 and word2 in the array wordsDict.
 * Example 1:
 * <p>
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"],
 * ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 * <p>
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 */
public class _244ShortestWordDistanceII {
    class WordDistance {
        Map<String, List<Integer>> pos = new HashMap<>();

        public WordDistance(String[] wordsDict) {
            // Prepare a mapping from a word to all it's locations (indices).
            for (int i = 0; i < wordsDict.length; i++) {
                String s = wordsDict[i];

                pos.putIfAbsent(s, new ArrayList<>());
                pos.get(s).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            if (!pos.containsKey(word1) || !pos.containsKey(word2)) return -1;
            // Location lists for both the words
            // the indices will be in SORTED order by default
            List<Integer> pos1 = pos.get(word1);
            List<Integer> pos2 = pos.get(word2);

            int i = 0, j = 0;
            int minDist = Integer.MAX_VALUE;

            while (i < pos1.size() && j < pos2.size()) {
                int dist1 = pos1.get(i);
                int dist2 = pos2.get(j);
                int diff = Math.abs(dist1 - dist2);

                if (diff == 1) return diff;   // Optimization here
                minDist = Math.min(diff, minDist);

                if (dist1 < dist2) i++;
                else j++;
            }

            return minDist;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
}
