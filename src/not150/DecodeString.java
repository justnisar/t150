package src.not150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {



    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == ']'){
                String temp = "";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String number = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    number = stack.pop() + number;
                }

                int n = Integer.parseInt(number);
                String result = "";
                while(n-- > 0){
                    result += temp;
                }
                stack.push(result);
            }
            else{
                stack.add(String.valueOf(ch));
            }

        }
        String result = "";
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}





