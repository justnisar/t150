package src;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int result = 0;
        int num = 5;
        int i = 1;
        while(n >= num){
            result +=  (int)Math.floor((double)n/num);
            i++;
            num = (int)Math.pow(5, i);
        }
        return result;
    }

    public static void main(String[] args) {
        new FactorialTrailingZeroes().trailingZeroes(200);
    }
}
