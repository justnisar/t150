public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0 , j = numbers.length - 1;
        while(i < j){

            int sum = numbers[i] + numbers[j];
            if(sum == target){
                result[0] = i+1;
                result[1] = j;
                break;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return result;
    }
}
