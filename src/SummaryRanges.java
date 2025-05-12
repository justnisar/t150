package src;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    private String getStart(String str){
        String[] strArr = str.split("->");
        return strArr[0];
    }

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        result.add(String.valueOf(nums[0]));
        for(int i = 1 ; i < nums.length ; i++){

            // If it is part of old series
            if(nums[i] - nums[i-1] == 1){
                String lastValue = result.get(result.size() - 1);

                result.remove(result.size() - 1);
                result.add(getStart(lastValue) + "->" + String.valueOf(nums[i]));
            }
            // If it is part of new series
            else{
                result.add(String.valueOf(nums[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {0,2,3,4,6,8,9};
        new SummaryRanges().summaryRanges(array);
    }
}
