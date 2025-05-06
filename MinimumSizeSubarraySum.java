public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;
        while(right < nums.length) {
            sumOfCurrentWindow += nums[right];
            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,2,6,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, array));
    }
}
