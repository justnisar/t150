package src;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (int[] a, int[] b) -> a[1] - b[1]);
        int result = 1;
        int end = points[0][1];
        for(int i = 1 ; i < points.length ; i++){
            if(points[i][0] <= end){
                continue;
            }
            else{
                result++;
                end = points[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{10,16},{2,8},{1,6},{7,12}};
        new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(array);
    }

}
