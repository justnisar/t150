package src;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length - 1 ; i >= 0 ; i--){
            int sum = digits[i] + carry;
            int digit = sum % 10;
            carry = sum/10;
            result.add(0, digit);
        }
        if(carry == 1){
            result.add(0,1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
