package src;

public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;
        while(left < right){
            left = left >> 1;
            right = right >> 1;
            shiftCount++;
        }
        return right << shiftCount;
    }

}
