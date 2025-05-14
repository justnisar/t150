package src;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private void recFun(List<List<Integer>> result, List<Integer> temp, int start ,int k, int n){
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start + 1 ; i <= n ; i++){
            temp.add(i);
            recFun(result, temp, i, k, n);
            temp.removeLast();
        }

    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        recFun(result, new ArrayList<>(), 0, k, n);

        return result;
    }

    public static void main(String[] args) {
        new Combinations().combine(4,2);
    }
}
