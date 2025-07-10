package src;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int maxSumSoFar = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSumSoFar = Integer.MAX_VALUE;
        int currentMin = 0;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
            currentMax = Math.max(currentMax + num, num);
            maxSumSoFar = Math.max(maxSumSoFar, currentMax);
            currentMin = Math.min(currentMin + num, num);
            minSumSoFar = Math.min(minSumSoFar, currentMin);
        }

        if(maxSumSoFar < 0){
            return maxSumSoFar;
        }

        return Math.max(maxSumSoFar, totalSum - minSumSoFar);
    }
}
