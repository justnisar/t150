package src;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a );
        for(int num : nums) {
            maxHeap.add(num);
        }

        while(k-- > 0){
            maxHeap.remove();
        }

        return maxHeap.peek();
    }

}
