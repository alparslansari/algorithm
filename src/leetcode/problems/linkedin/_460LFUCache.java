package leetcode.problems.linkedin;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 460. LFU Cache
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * <p>
 * Implement the LFUCache class:
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 * When the cache reaches its capacity, it should invalidate and remove the least frequently used key
 * before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency),
 * the least recently used key would be invalidated.
 * <p>
 * To determine the least frequently used key, a use counter is maintained for each key in the cache.
 * The key with the smallest use counter is the least frequently used key.
 * <p>
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 * // cache=[4,3], cnt(4)=2, cnt(3)=3
 */
public class _460LFUCache {
    class LFUCache {

        private final int capacity;
        private final Map<Integer, Integer> data; // Key -> Value
        private final Map<Integer, Integer> counters; // Key -> Counter
        private final Map<Integer, Set<Integer>> reverse; // Counter -> Set<Key>
        private int minCounter;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.data = new HashMap<>();
            this.counters = new HashMap<>();
            this.reverse = new HashMap<>();
        }

        public int get(int key) {
            Integer value = data.get(key);
            if (value == null) {
                return -1;
            }
            touch(key);
            return value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (data.size() == capacity && !data.containsKey(key)) {
                evict();
            }
            data.put(key, value);
            touch(key);
        }

        private void touch(int key) {
            int keyCount = counters.compute(key, (k, v) -> (v == null) ? 1 : (v + 1));
            reverse.computeIfAbsent(keyCount, k -> new LinkedHashSet<>()).add(key);

            int prevCount = keyCount - 1;
            if (reverse.containsKey(prevCount)) {
                Set<Integer> prevKeySet = reverse.get(prevCount);
                prevKeySet.remove(key);
                if (prevKeySet.isEmpty()) {
                    reverse.remove(prevCount);
                    if (prevCount == minCounter) {
                        minCounter = keyCount;
                    }
                }
            } else {
                minCounter = keyCount; // New key (i.e. keyCount = 1)
            }
        }

        private void evict() {
            Set<Integer> keySet = reverse.get(minCounter);
            int keyToEvict = keySet.iterator().next();
            data.remove(keyToEvict);
            counters.remove(keyToEvict);
            keySet.remove(keyToEvict);
            if (keySet.isEmpty()) {
                reverse.remove(minCounter);
            }
            // No need to change `minCounter` because `touch()` will set it to 1 later
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
