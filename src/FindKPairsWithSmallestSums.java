package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> (nums1[a[0]] + nums2[a[1]])
                - (nums1[b[0]] + nums2[b[1]]));


        for(int i = 0 ; i < nums1.length ; i++){
            priorityQueue.add(new int[]{i,0});
        }

        while(k-- > 0 && !priorityQueue.isEmpty()) {
            int[] pair = priorityQueue.poll();
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            if (pair[1] + 1 < nums2.length) {
                priorityQueue.add(new int[]{pair[0], pair[1] + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k);
    }
}
