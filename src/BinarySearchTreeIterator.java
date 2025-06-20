package src;

import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack;

    public void BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode current = root;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
    }

    public int next() {
        TreeNode current = stack.pop();
        int result = current.val;
        current = current.right;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
