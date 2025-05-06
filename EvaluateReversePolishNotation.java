import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        int result = 0 ;

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            try{
                int number = Integer.parseInt(token);
                stack.push(number);
            }
            catch(NumberFormatException ex){

                int b = stack.pop();
                int a = stack.pop();

                switch (token){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;

                }


            }


        }


        return stack.pop();
    }
}
