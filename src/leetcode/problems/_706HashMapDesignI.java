package leetcode.problems;

/**
 * 706. Design HashMap
 */
public class _706HashMapDesignI {
    MyHashMap obj = new MyHashMap();
}

class MyHashMap {

    /** Initialize your data structure here. */
    Integer[] imap;
    public MyHashMap() {
        this.imap = new Integer[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.imap[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if( this.imap[key] == null ) return -1;

        return this.imap[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.imap[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
