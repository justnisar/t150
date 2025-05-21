package src;

import java.util.Objects;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minTracker;

    public MinStack() {
        stack = new Stack<>();
        minTracker = new Stack<>();
    }

    public void push(int val) {
        if(minTracker.isEmpty() || val < minTracker.peek()){
            minTracker.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(Objects.equals(stack.peek(), minTracker.peek())){
            minTracker.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minTracker.peek();
    }
}
