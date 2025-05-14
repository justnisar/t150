package src;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private void recFun(List<List<Integer>> result, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int num : nums){
            if(!temp.contains(num)){
                temp.add(num);
                recFun(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recFun(result, new ArrayList<Integer>(), nums);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        new Permutations().permute(array);
    }
}
