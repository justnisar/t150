package src;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while(true){

            int mid = left + (right = left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
        }
    }

    private int findLeftMostInsertionPoint(int[] nums, int target){
        /*int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                right = mid;
            }
            else if(nums[mid] )
        }*/
        return 0;
    }
}
