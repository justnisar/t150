public class RotateArray {

    int[] getReverseFromTo(int[] array, int start,int end){
        int i = start, j = end;
        while(i < j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }

    public void rotate(int[] nums, int k) {

        nums = getReverseFromTo(nums,0,nums.length-1);
        nums = getReverseFromTo(nums,0,k-1);
        nums = getReverseFromTo(nums,k,nums.length-1);
    }
}
