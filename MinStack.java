import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private Stack<Integer> minStack;
    private Stack<Integer> latestStack;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if(stack1.isEmpty() && stack2.isEmpty()){
            minStack = stack2;
            latestStack = stack2;
            stack2.push(val);
        }
    }

    public void pop() {

    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return 0;
    }
}
