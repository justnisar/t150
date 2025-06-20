package src.not150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        for(int i = 1 ; i < intervals.length ; i++){
            int[] prev = intervals[i-1];
            int[] current = intervals[i];
            if(current[0] >= prev[0] && current[0] <= prev[1]){
                return false;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.comparingInt(Integer::intValue));
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        new MeetingRooms().canAttendMeetings(intervals);
    }
}
