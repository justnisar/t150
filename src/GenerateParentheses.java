package src;
import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {

    private void recFun(List<String> result, int openCount, int closedCount, int totalCount, String temp){

        if(temp.length() == 2 * totalCount){
            result.add(temp);
            return;
        }

        if(openCount < totalCount){
            temp += '(';
            recFun(result, openCount + 1, closedCount, totalCount, temp);
            temp = temp.substring(0, temp.length() - 1);
        }

        if(openCount > closedCount){
            temp += ')';
            recFun(result, openCount, closedCount + 1, totalCount, temp);
            temp = temp.substring(0, temp.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        recFun(result, 0, 0 , n, "");
        return result;
    }
}
