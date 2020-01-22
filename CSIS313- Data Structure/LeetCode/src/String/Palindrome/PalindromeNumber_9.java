package String.Palindrome;

public class PalindromeNumber_9 {

    //Time: O(log n)  Space:O(1)
    //run time: 15ms  (7.2%)
  /*  public boolean isPalindrome(int x){
        int num = x;
        int res = 0;
        while(x > 0){
            int lastDigit =  x % 10;
            x /= 10;
            res = res * 10 + lastDigit;

        }
        return res==num;
    }

   */

  //run: 12 ms (10%)
    public boolean isPalindrome(int x){
        if(x < 0 || x != 0 && x % 10==0) return false;
        if(x < 10) return true;

        int num = x;
        int res = 0;
        while(num > 9){
            int lastDigit = num % 10;
            res = res * 10 + lastDigit;
            num /= 10;
        }

        if(num != x%10) return false;
        x /= 10;
        if(x == res) return true;
        else return false;
    }
}
