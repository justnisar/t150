package src;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int levelSize = queue.size();
            Node prev = null;
            for(int i = 0 ; i < levelSize ; i++){

                Node current = queue.poll();
                if(current.right != null){
                    queue.add(current.right);
                }
                if(current.left != null){
                    queue.add(current.left);
                }
                current.next = prev;
                prev = current;
            }


        }
        return root;
    }

}
