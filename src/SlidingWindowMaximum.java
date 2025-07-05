package src;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (a,b) -> b[0] - a[0]
        );

        for(int i = 0 ; i < k - 1 ; i++){
            priorityQueue.add(new int[]{nums[i],i});
        }

        for(int i = 0 ; i < nums.length - k + 1 ; i++){
            priorityQueue.add(new int[]{nums[i + k - 1], i + k - 1});
            while(!priorityQueue.isEmpty()){
                int[] pair = priorityQueue.peek();
                int number = pair[0];
                int index = pair[1];
                // is index valid
                if(index >= i && index < i + k){
                    result[i] = number;
                    break;
                }
                else{
                    priorityQueue.poll();
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        new SlidingWindowMaximum().maxSlidingWindow(array, k);
    }
}
