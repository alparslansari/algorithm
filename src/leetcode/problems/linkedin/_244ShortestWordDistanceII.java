package leetcode.problems.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 244. Shortest Word Distance II
 * Design a data structure that will be initialized with a string array,
 * and then it should answer queries of the shortest distance between two different strings
 * from the array.
 *
 * Implement the WordDistance class:
 *  WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 *   int shortest(String word1, String word2) returns the shortest distance between word1
 *   and word2 in the array wordsDict.
 *
 *
 *
 * Example 1:
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 *
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
            for(int i = 0; i < wordsDict.length; i++) {
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

            while(i < pos1.size() && j < pos2.size()) {
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

    class WordDistance0 {

        HashMap<String, ArrayList<Integer>> locations;

        public WordDistance0(String[] words) {
            this.locations = new HashMap<String, ArrayList<Integer>>();
            // Prepare a mapping from a word to all it's locations (indices).
            for (int i = 0; i < words.length; i++) {
                ArrayList<Integer> loc = this.locations.getOrDefault(words[i], new ArrayList<Integer>());
                loc.add(i);
                this.locations.put(words[i], loc);
            }
        }

        public int shortest(String word1, String word2) {
            ArrayList<Integer> loc1, loc2;

            // Location lists for both the words
            // the indices will be in SORTED order by default
            loc1 = this.locations.get(word1);
            loc2 = this.locations.get(word2);

            int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
            while (l1 < loc1.size() && l2 < loc2.size()) {
                minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
                if (loc1.get(l1) < loc2.get(l2)) {
                    l1++;
                } else {
                    l2++;
                }
            }

            return minDiff;
        }
    }
}
