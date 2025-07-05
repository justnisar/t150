package src;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = height[0];

        for(int i = 0 ; i < height.length ; i++){
            if(height[i] > max){
                max = height[i];
            }
            left[i] = max;
        }
        max = 0;
        for(int i = height.length - 1 ; i >= 0 ; i--){
            if(height[i] > max){
                max = height[i];
            }
            right[i] = max;
        }

        int result = 0;

        for(int i = 1 ; i < height.length - 1 ; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
