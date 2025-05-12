package src;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        int majorityElement = nums[0];
        int count = 1;

        for(int i = 1 ; i < nums.length ; i++) {

            if(nums[i] == majorityElement) {
                count++;
                continue;
            }
            count--;
            if(count == 0) {
                majorityElement = nums[i];
                count = 1;
            }

        }

        return majorityElement;
    }
}
