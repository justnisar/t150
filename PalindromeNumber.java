import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    private int getDigitCount(int number){
        int result = 0;
        while(number != 0){
            result++;
            number = number / 10;
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int digitCount = getDigitCount(x);
        int start = 0, end = digitCount - 1;
        int startNumber = x, endNumber = x;
        int zeroCount = digitCount - 1;

        while(start < end){
           int tenPower = (int)Math.pow(10, zeroCount);
           int startDigit = startNumber / tenPower;
           startNumber = startNumber % tenPower;
           int endDigit = endNumber % 10;
           if(startDigit != endDigit){
               return false;
           }
           endNumber = endNumber / 10;
            zeroCount--;
            start++;
            end--;
        }
        return true;
    }
}
