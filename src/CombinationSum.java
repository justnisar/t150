package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    private void recFun(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target){

        if(target == 0){
            List<Integer> temp1 = new ArrayList<>(temp);
            Collections.sort(temp1);
            if(!result.contains(temp1)){
                result.add(temp1);
            }
            return;
        }

        if(target < 0){
            return;
        }

        for(int candidate : candidates){

            temp.add(candidate);
            if(target - candidate >= 0){
                recFun(result, temp, candidates, target - candidate);
            }
            temp.removeLast();
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        recFun(result, new ArrayList<>(), candidates, target);

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        new CombinationSum().combinationSum(candidates, 8);
    }

}
