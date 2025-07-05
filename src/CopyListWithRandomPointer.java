package src;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }

        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = copyRandomList(head.next);
        clone.random = copyRandomList(head.random);
        return clone;
    }

}
