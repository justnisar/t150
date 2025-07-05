package src;

import java.util.*;

public class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    Node head;
    Node tail;
    int capacity;

    Map<Integer,Node> cache;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = removeFromBeginning();
            addToEnd(node);
        }
        return -1;
    }

    public Node removeFromBeginning(){
        Node current = head;
        head = head.next;
        return current;
    }

    public void addToEnd(Node node){
        tail.next = node;
        tail = node;
    }

    public void put(int key, int value) {
        // If key present in cache
        if(cache.containsKey(key)){

        }
        // Key not present in cache
        else{
            // capacity exceeded
            if(cache.size() == this.capacity){
                // Remove least recently used
                Node node = removeFromBeginning();
                cache.remove(node.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

}
