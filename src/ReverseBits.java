package src;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;
        for(int i = 0 ; i < 32 ; i++){
            int currentBit = n & 1;

            n = n >> 1;
            result = result << 1;
            result = result | currentBit;
        }

        return result;
    }


}
