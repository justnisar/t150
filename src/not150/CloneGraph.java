package src.not150;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    Map<Node, Node> originalToCloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        if(originalToCloneMap.containsKey(node)){
            return originalToCloneMap.get(node);
        }

        Node clone = new Node(node.val);
        originalToCloneMap.put(node, clone);
        for(Node neighbour : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbour));
        }

        return clone;
    }

}
