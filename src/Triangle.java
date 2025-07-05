package src;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size();
        if(rows == 1){
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;

        for(int i = 1 ; i < rows ; i++){

            for(int j = 0 ; j < triangle.get(i).size() ; j++){

                int currentMin = Integer.MAX_VALUE;
                int currentVal = triangle.get(i).get(j);
                if(j - 1 >= 0){
                    currentMin = Math.min(currentMin, triangle.get(i-1).get(j-1) + currentVal);
                }
                if(j < triangle.get(i-1).size()){
                    currentMin = Math.min(currentMin, triangle.get(i-1).get(j) + currentVal);
                }
                triangle.get(i).set(j, currentMin);
                if(i == rows - 1){
                    min = Math.min(min, currentMin);
                }
            }

        }

        return min;
    }
}
