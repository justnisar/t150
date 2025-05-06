import java.util.Stack;

public class SimplifyPath {

    private boolean canOmit(String str){
        return str.equals(".") || str.equals("/") || str.equals("");
    }

    public String simplifyPath(String path) {

        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : pathArr) {
            if(str.equals("..") && !stack.isEmpty()){
               if(!stack.isEmpty()) {
                   stack.pop();
               }
               continue;
            }
            else if(canOmit(str)){
                continue;
            }
            else{
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < stack.size(); i++){
            sb.append("/");
            sb.append(stack.get(i));
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        new SimplifyPath().simplifyPath("/../");
    }
}
