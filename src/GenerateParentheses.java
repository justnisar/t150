package src;
import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {

    private void recFun(List<String> result, int openCount, int closedCount, int totalCount, String temp){

        if(openCount == totalCount){
            result.add(new String(temp));
            return;
        }


    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        recFun(result, 0, 0 , n, "");
        return result;
    }
}
