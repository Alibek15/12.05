package models;

public class Tree<K,V> {
    private K key;
    private V value;
    public Tree(){}
    public Tree(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
