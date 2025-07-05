package src;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = findLeftMostInsertionPoint(nums, target);
        if(left == nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }
        int right = findLeftMostInsertionPoint(nums, target + 1);
        return new int[]{left, right - 1};
    }

    private int findLeftMostInsertionPoint(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
