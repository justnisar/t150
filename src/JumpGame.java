package src;

public class JumpGame {

    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 1;
        }
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > max){
                return -1;
            }
            max = Math.max(max, i + nums[i]);
            if(max >= nums.length - 1){
                return i+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,1,4};
        //int[] array = {3,2,1,0,4};
        new JumpGame().jump(array);

    }

}
