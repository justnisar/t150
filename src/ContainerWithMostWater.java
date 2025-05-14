package src;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int max = -1;

        int i = 0, j = height.length - 1;

        while(i < j){
            int current = Math.min(height[i], height[j]) * (j - i + 1);
            if(current > max){
                max = current;
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return max;
    }
}
