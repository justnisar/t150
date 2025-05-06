public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        // Should I start here or not

        int maxSubarraySum = nums[0];
        int maxTillNow = nums[0];

        for(int i = 1 ; i < nums.length ; i++){

            // Should I start the subarray here or should I continue from previous subarray

            maxTillNow = Math.max(nums[i] , nums[i] + maxTillNow);
            maxSubarraySum = Math.max(maxTillNow, maxSubarraySum);


        }


        return maxSubarraySum;
    }

    public static void main(String[] args) {
        int[] array = {5,4,-1,7,8};
        new MaximumSubarray().maxSubArray(array);
    }
}
