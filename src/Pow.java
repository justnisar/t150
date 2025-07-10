package src;

public class Pow {

    private double helper(double x, long n){
        if(x == 1){
            return 1;
        }
        if(n == 0){
            return 1;
        }
        else if(n == 1){
            return x;
        }
        else if(n < 0){
            return 1/helper(x, -n);
        }
        double temp = helper(x, n/2);
        if(n % 2 == 0){
            return temp * temp;
        }
        return x * temp * temp;
    }

    public double myPow(double x, int n) {
        return helper(x, (long)n);
    }
}
