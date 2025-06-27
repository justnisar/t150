package src.not150;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){

            char current = s.charAt(i);
            if(current == '('){
                stack.push(i);
            }
            else if(current == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }
                else{
                    stack.push(i);
                }
            }

        }
        String result = "";
        for(int i = s.length() - 1 ; i >= 0 ;  i--){
            if(!stack.isEmpty() && stack.peek() == i){
                stack.pop();
                continue;
            }
            result = s.charAt(i) + result;
        }
        return result;
    }

}
