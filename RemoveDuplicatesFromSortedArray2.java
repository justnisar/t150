public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {

        int result = 0;
        int j = 0;
        int current = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] == current){

                if(count < 2){
                    count++;
                    nums[j] = nums[i];
                    j++;
                    result++;
                }

            }
            else{

                current = nums[i];
                count = 1;
                nums[j] = nums[i];
                j++;
                result++;
            }



        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,3};
        new RemoveDuplicatesFromSortedArray2().removeDuplicates(array);
    }


}
