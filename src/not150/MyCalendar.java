package src.not150;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    private List<int[]> intervalList;
    public MyCalendar() {
        intervalList = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for(int[] interval : intervalList){
            if(startTime < interval[1] && endTime > interval[0]){
                return false;
            }
        }
        intervalList.add(new int[]{startTime, endTime});
        return true;
    }

    public static void main(String[] args) {

    }
}
