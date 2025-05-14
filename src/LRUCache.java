package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map;
    int nodeCount;

    public LRUCache(int capacity) {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
        nodeCount = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode currentNode = removeFromList(key);
        insertAtEnd(key,currentNode);
        return map.get(key).val;
    }

    private void insertAtEnd(int key, ListNode currentNode){
        map.put(key, currentNode);
        ListNode currentTail = tail.prev;
        currentTail.next = currentNode;
        currentNode.prev = currentTail;
        currentNode.next = tail;
        tail.prev = currentNode;
        nodeCount++;
    }

    private ListNode removeFromList(int key){
        map.remove(key);
        ListNode currentNode = map.get(key);
        ListNode prev = currentNode.prev;
        ListNode next = currentNode.next;
        prev.next = next;
        next.prev = prev;
        nodeCount--;
        return currentNode;

    }

    private void removeFromBeginning(int key){
        // least recently used is at the front of the list
        // remove from map
        ListNode currentHead = head.next;
        map.remove(key);
        head.next = currentHead.next;
        currentHead.next.prev = head;
        nodeCount--;
    }

    public void put(int key, int value) {

        ListNode currentNode;

        // If it already exists in the cache, we just need to update the value

        if(map.containsKey(key)){
            currentNode = removeFromList(key);
            // update with new value
            currentNode.val = value;
        }
        else{
            currentNode = new ListNode(value);
            // need to evict
            if(nodeCount == capacity){
                removeFromBeginning(key);
            }
        }

        // most recent one insert at end
        insertAtEnd(key, currentNode);

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // cache is {1=1}
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
