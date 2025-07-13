package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InsertInterval {
/*
    public int[][] insert(int[][] intervals, int[] newInterval) {



        List<int[]> list = new ArrayList<>();
        boolean newIntervalAdded = false;

        for(int[] interval: intervals){

            // case 1 : new interval is already added
            if(newIntervalAdded){
                list.add(interval);
            }

            // case 2 current interval overlaps with new interval
            else if((newInterval[0] >= interval[0] && newInterval[0] <= interval[1])
                || (interval[0] >= newInterval[0] && interval[0] <= newInterval[1])){
                newInterval[0] = Math.min(newInterval[0],interval[0]);
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }

            // case 3 current interval does not overlap with new interval and
            // new interval start time is smaller
            else if(interval[0] < newInterval[0]){
                list.add(interval);
            }

            // case 4 current interval overlaps with new interval and
            // current interval start time is smaller

            else {
                list.add(newInterval);
                list.add(interval);
                newIntervalAdded = true;
            }

        }

        if(!newIntervalAdded){
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }

 */

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;

        // interval ended before new interval started, so directly add to result
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
                result.add(intervals[i]);
                i++;
        }

        // merge all intervals overlapping with new interval
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // add new interval
        result.add(newInterval);

        // new interval already merged. Add all remaining intervals
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,8},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        new InsertInterval().insert(intervals, newInterval);
    }
}
