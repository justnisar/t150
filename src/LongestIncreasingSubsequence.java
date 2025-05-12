package src;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = 1;

        int result = 1;

        for(int i = 1 ; i < nums.length ; i++) {
            int max = 1;
            for(int j = 0 ; j < i ; j++) {

                if(nums[i] > nums[j]) {

                    max = Math.max(max, dp[j] + 1);

                }

            }
            dp[i] = max;
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
