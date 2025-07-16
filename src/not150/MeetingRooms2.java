package src.not150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a));
        for(int[] interval : intervals){
            int currentIntervalStartTime = interval[0];
            int currentIntervalEndTime = interval[1];
            if(priorityQueue.isEmpty()){
                priorityQueue.add(interval[1]);
                continue;
            }
            int firstAvailableIntervalEndTime = priorityQueue.peek();
            if(firstAvailableIntervalEndTime <= currentIntervalStartTime){
                priorityQueue.poll();
            }
            priorityQueue.add(currentIntervalEndTime);
        }
        return priorityQueue.size();
    }
}
