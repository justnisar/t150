package src;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {

        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int number = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result = result + sign * number;
            }
            else if(ch == '+'){
                sign = 1;
            }
            else if(ch == '-'){
                sign = -1;
            }
            else if(ch == '('){
                stack.add(result);
                stack.add(sign);
                result = 0;
                sign = 1;
            }
            else if(ch == ')'){
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
        }

        return result;
    }
}
