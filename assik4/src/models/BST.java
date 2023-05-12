package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BST<K extends Comparable<K>, V>{
    private Node root;

    private class Node{
        private K key;
        private V val;
        private Node left,right;
        public Node(K key, V val){
            this.key=key;
            this.val=val;
        }
    }
    public void put(K key, V val){
        root=putIt(key,val,root,0);

    }
    private Node putIt(K key, V val,  Node node, Integer size){

        if(root.equals(null)){
            return new Node(key, val);
        }
        else if(key.compareTo(root.key)<0){
            node.left=putIt(key,val, node.left, size+1);
        }
        else if(key.compareTo(root.key)>0){
            node.right=putIt(key,val, node.right, size+1);
        }
        else {
            node.val=val;
            node.key=key;
        }

        return node;
    }
    public V get(K key){
        Node checkValue=getIt(key,root);
        return checkValue.val;
    }
    private Node getIt(K key, Node root){
        if(Objects.nonNull(root)) {
            if (key.equals(root)) {
                return root;
            } else if (key.compareTo(root.key) < 0) {
                return getIt(key, root.left);
            } else if (key.compareTo(root.key) > 0) {
                return getIt(key, root.right);
            }
            return root;
        }
        else{
            return null;
        }
    }
    public void delete(K key){
        root=deleteIt(root,key);
    }
    private Node deleteIt(Node root, K key){
        if(root.equals(null)){
            return root;
        }
        if(key.compareTo(root.key)<0){
            root.left=deleteIt(root.left,key);
        }
        else if(key.compareTo(root.key)>0){
            root.right=deleteIt(root.right,key);
        }
        else{
            if(root.left.equals(null)){
                return root.right;
            }
            else if(root.right.equals(null)){
                return root.left;
            }
            root.key=min(root.right);
            root.right=deleteIt(root.right,root.key);
        }
        return root;
    }
    private K min(Node root){
        while (Objects.nonNull(root.left)){
            root.key=root.left.key;
            root=root.left;
        }
        return root.key;
    }
    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }

    private void inOrderTraversal(Node node, List<K> keys) {
        if ( Objects.isNull(node)) {
            return;
        }
        inOrderTraversal(node.left, keys);
        keys.add(node.key);
        inOrderTraversal(node.right, keys);
    }

    public int addSize(){
        int size=size();
        return size+1;
    }

    public int size(){
        return(getSize(root));
    }
    private int getSize(Node node){

        if(node.equals(null)){
            return (0);
        }
        else{
            return(getSize(node.left)+getSize(node.right)+1);
        }
    }
}

/*1) Add size (10%)

2) Implement in-order traversal for iterator() (20%)

3) Make it possible for both key and value to be accessible during the iteration (20%)*/
