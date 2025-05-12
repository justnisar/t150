package src;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int index = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] != prev){
                nums[index] = nums[i];
                index++;
                prev = nums[i];
            }
        }
        return index;
    }
}
