package leetcode.problems.linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 432. All O`one Data Structure
 *  Design a data structure to store the strings' count with the ability to return
 *  the strings with minimum and maximum counts.
 *
 * Implement the AllOne class:
 *
 * AllOne() Initializes the object of the data structure.
 *  inc(String key) Increments the count of the string key by 1. If key does not exist
 *     in the data structure, insert it with count 1.
 *  dec(String key) Decrements the count of the string key by 1. If the count of key
 *     is 0 after the decrement, remove it from the data structure. It is guaranteed
 *     that key exists in the data structure before the decrement.
 *  getMaxKey() Returns one of the keys with the maximal count. If no element exists,
 *  return an empty string "".
 *  getMinKey() Returns one of the keys with the minimum count. If no element exists,
 *  return an empty string "".
 */
public class _432AllOoneDataStructure {
    class AllOne {

        private class BucketNode{
            int val;
            BucketNode count;
            BucketNode pre;
            BucketNode next;
            Set<String> keySet;
            private BucketNode(int val){
                this.val = val;
                keySet = new HashSet<>();
            }

        }

        private BucketNode head;
        private BucketNode tail;
        private Map<String, Integer> keyValueMap;
        private Map<Integer, BucketNode> valueBucketMap;

        /** Initialize your data structure here. */
        public AllOne() {
            head = new BucketNode(Integer.MIN_VALUE);
            tail = new BucketNode(Integer.MAX_VALUE);
            keyValueMap  = new HashMap<>();
            valueBucketMap = new HashMap<>();
            // link head and tail
            head.next = tail;
            tail.pre = head;
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if(keyValueMap.containsKey(key)){
                changeValue(key, 1);
            }
            else{

                if(head.next.val != 1){
                    addBucketAfter(new BucketNode(1),head);
                }

                head.next.keySet.add(key);

                // add the mapping
                keyValueMap.put(key, 1);
                valueBucketMap.put(1, head.next);
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if(keyValueMap.containsKey(key)){
                if(keyValueMap.get(key) == 1){
                    // remove key from KV map
                    keyValueMap.remove(key);
                    // remove key from Bucket
                    removeKeyfromBucket(valueBucketMap.get(1), key);
                }
                else{
                    changeValue(key, -1);
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return tail.pre == head? "": (String)tail.pre.keySet.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return head.next == tail? "": (String)head.next.keySet.iterator().next();
        }

        private void changeValue(String key, int offset){
            int curVal = keyValueMap.get(key);
            BucketNode curBucket = valueBucketMap.get(curVal);
            BucketNode newBucket;
            if(valueBucketMap.containsKey(curVal + offset)){
                newBucket = valueBucketMap.get(curVal + offset);
            }
            else{
                newBucket = new BucketNode(curVal + offset);
                addBucketAfter(newBucket, offset == 1 ?curBucket: curBucket.pre);
                valueBucketMap.put(curVal + offset, newBucket);
            }

            // remove the key from curBucket
            removeKeyfromBucket(curBucket, key);

            // add the key to newBucket
            newBucket.keySet.add(key);
            // update the record
            keyValueMap.put(key, curVal + offset);

        }

        private void addBucketAfter(BucketNode newBucket, BucketNode pre){
            newBucket.pre = pre;
            newBucket.next = pre.next;
            pre.next.pre = newBucket;
            pre.next = newBucket;

        }

        private void removeKeyfromBucket(BucketNode bucket, String key){
            // remove key from bucket
            bucket.keySet.remove(key);
            if(bucket.keySet.size() == 0){
                removeBucketfromBucketList(bucket);
                valueBucketMap.remove(bucket.val);
            }
        }

        private void removeBucketfromBucketList(BucketNode bucket){
            bucket.pre.next = bucket.next;
            bucket.next.pre = bucket.pre;
            bucket.pre = null;
            bucket.next = null;
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
