import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char top = stack.peek();
            if(ch == '}' && top == '{'){
                stack.pop();
            }
            else if(ch == ')' && top == '('){
                stack.pop();
            }
            else if(ch == ']' && top == '['){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("()[]{}");
    }
}
