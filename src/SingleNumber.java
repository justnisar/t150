package src;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums){
            result ^= n;
        }
        return result;
    }
}
