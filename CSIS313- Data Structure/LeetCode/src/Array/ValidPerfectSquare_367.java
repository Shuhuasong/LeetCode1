package Array;

public class ValidPerfectSquare_367 {
    //Time: O(n)  Space: O(1)
   /* public boolean isPerfectSquare(int num) {
        if(num==0) return false;
        if(num==1) return true;
        for(int i=0; i<=num/i; i++){
            if(i*i==num) return true;
        }
        return false;
    }

    */
     //Time: O(logn)  Space: O(1)
    public boolean isPerfectSquare(int num) {
        if(num==0) return false;
        if(num==1) return true;
        int left = 0;
        int right = num/2+1;
        while(left <= right){
            long mid = left+(right-left)/2;//deal with overflow
            //int prod = mid * mid;
            if(mid * mid==num) {
                return true;  }
            else if(mid * mid < num) {
                left =(int) mid+1;
            }
            else {
                right =(int) mid-1;
            }
        }
        return false;
    }
}
