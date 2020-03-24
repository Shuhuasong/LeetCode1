package Recursive;

public class Pow_50 {
  /*  public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;
        if(n < 0) return 1/(x*myPow(x, -(n+1)));
        double res = 1;

        while(n > 1){
            if(n%2 != 0){
                res = res * x;
            }
            x = x * x;
            n = n/2;
        }
        res *= x;
        return res;
    }
   */
  //recursion
    public double myPow(double x, int n) {

        if(n > 0){
            return pow(x, n);
        }
        else{
            return 1.0/pow(x,n);
        }
    }

    private double pow(double x, int n){
        if(n==0) return 1;
        double y = pow(x, n/2);
        if(n % 2 == 0){
            return y * y;
        }else{
            return y * y * x;
        }
    }
}
