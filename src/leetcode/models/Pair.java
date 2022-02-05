package leetcode.models;

public class Pair<U, V> {
    private U first;
    private V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }


    public U getKey() {
        return this.first;
    }

    public V getValue() {
        return this.second;
    }
}