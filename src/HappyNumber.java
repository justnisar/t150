package src;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private int getSumOfSquaresOfDigits(int number){
        int result = 0;
        while(number != 0){
            int digit = number % 10;
            result += (int)Math.pow(digit, 2);
            number = number/10;
        }
        return result;
    }

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = getSumOfSquaresOfDigits(n);
        }

        return n == 1;
    }
}
