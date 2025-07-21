package src;

import java.util.Arrays;

public class JumpGame2 {

    /*
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= nums[i] ; j++){
                if(i + j > nums.length - 1){
                    continue;
                }
                int temp = dp[i + j];
                min = Math.min(min, temp);
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = 1 + min;
            }
        }
        return dp[0];
    }
*/

    public int jump(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }

        int currentLevelEnd = 0;
        int jumpCount = 0;
        int maxReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == currentLevelEnd) {
                jumpCount += 1;
                currentLevelEnd = maxReachable;
                if (currentLevelEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{0}));
    }
}
