package src;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){

            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else if(map.get(num) == 2){
                map.remove(num);
            }
            else{
                map.put(num,2);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            return entry.getKey();
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {30000,500,100,30000,100,30000,100};
        new SingleNumber2().singleNumber(array);
    }

}
