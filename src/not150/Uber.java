package src.not150;

/*
Given list1 =[(1,2),(3,4)] and list2 =[(2,3),(5,6)], return[(1,4),(5,6)].
 */

import java.util.ArrayList;
import java.util.List;

public class Uber {

    private boolean canMerge(int[] interval1, int[] interval2){
        if(interval1[0] > interval2[0]){
            return canMerge(interval2, interval1);
        }
        return interval2[0] >= interval1[0] && interval2[0] <= interval1[1];
    }

    private int[] getMergedInterval(int[] interval1, int[] interval2){
        return new int[]{Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }

    private void addToResult(List<int[]> result, int[] interval) {
        if (result.size() == 0) {
            result.add(interval);
        } else {
            int[] lastInterval = result.get(result.size() - 1);
            if (canMerge(lastInterval, interval)) {
                int[] newInterval = getMergedInterval(lastInterval, interval);
                result.removeLast();
                result.add(newInterval);
            } else {
                result.add(interval);
            }
        }
    }

    private List<int[]> mergeSortedIntervalLists(int[][] list1, int[][] list2){

        List<int[]> result = new ArrayList<>();

        int p = 0;
        int q = 0;

        while(p < list1.length && q < list2.length){

            int[] intervalP = list1[p];
            int[] intervalQ = list2[q];

            if(canMerge(intervalP, intervalQ)){
                int[] newInterval = getMergedInterval(intervalP, intervalQ);
                addToResult(result, newInterval);
                p++;
                q++;
            }
            else if(intervalP[0] < intervalQ[0]){
                addToResult(result, intervalP);
                p++;
            }
            else{
                addToResult(result, intervalQ);
                q++;
            }
        }
        while(p < list1.length){
            result.add(list1[p]);
            p++;
        }
        while(q < list2.length){
            result.add(list2[q]);
            q++;
        }
        return result;
    }
}
