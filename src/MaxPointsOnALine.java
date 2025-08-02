package src;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {

        if (points.length <= 2) {
            return points.length;
        }

        int maxPointsOnLine = 0;

        for(int i = 0 ; i < points.length ; i++){
            Map<String, Integer> slopeCountMap = new HashMap<>();
            int currentMax = 0;
            for(int j = i + 1 ; j < points.length ; j++){
               String slopeKey = makeSlopeKey(points[i], points[j]);
               int newValueForSlopeKey = 1 + slopeCountMap.getOrDefault(slopeKey, 0);
               currentMax = Math.max(currentMax, newValueForSlopeKey);
               slopeCountMap.put(slopeKey, newValueForSlopeKey);
            }
            maxPointsOnLine = Math.max(maxPointsOnLine, currentMax + 1);
        }

        return maxPointsOnLine;
    }

    private String makeSlopeKey(int[] pointA, int[] pointB){
        int yDiff = pointB[1] - pointA[1];
        int xDiff = pointB[0] - pointA[0];
        if(xDiff == 0){
            return "infinite";
        }
        else if(yDiff == 0){
            return "zero";
        }
        int gcd = gcd(Math.abs(xDiff), Math.abs(yDiff));
        // Perform division first
        int simplifiedY = yDiff / gcd;
        int simplifiedX = xDiff / gcd;

        // Now, perform canonicalization on the simplified fraction
        if(simplifiedX < 0){
            simplifiedX = -simplifiedX;
            simplifiedY = -simplifiedY;
        }
        return simplifiedY + "|" + simplifiedX;
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
