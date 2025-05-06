import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i = 1 ; i < intervals.length ; i++){

            int[] last = result.get(result.size() - 1);
            // merge
            if(intervals[i][0] <= last[1]){
                result.remove(result.size() - 1);
                result.add(new int[]{last[0], Math.max(last[1],intervals[i][1])});
            }
            else{
                result.add(intervals[i]);
            }
        }

        int[][] resultArr = new int[result.size()][2];
        for(int i = 0 ; i < result.size() ; i++){
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}
