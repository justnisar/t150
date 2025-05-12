package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int low = 1;
        int high = nums.length - 1;
        for(int i = 0 ; i < nums.length ; i++){
            low = i + 1;
            high = nums.length - 1;
            while(low < high){

                int current = nums[i] + nums[low] + nums[high];

                if(current == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    result.add(temp);
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low-1]){
                        low++;
                    }
                }
                else if(current < 0){
                    low++;
                }
                else{
                    high--;
                }

            }


        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
        new ThreeSum().threeSum(array);
    }
}
