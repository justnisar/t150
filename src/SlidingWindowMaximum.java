package src;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);
        for(int i = 0 ; i < k ; i++){
            priorityQueue.add(new int[]{nums[i], i});
        }
        int j = 0;
        for(int i = k ; i < nums.length ; i++){
            int[] current = priorityQueue.peek();
            result[j++] = current[0];
            while(!priorityQueue.isEmpty() && priorityQueue.peek()[1] < i - k + 1){
                priorityQueue.poll();
            }
            priorityQueue.add(new int[]{nums[i], i});
        }
        result[j] = priorityQueue.peek()[0];
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        new SlidingWindowMaximum().maxSlidingWindow(array, k);

    }
}
