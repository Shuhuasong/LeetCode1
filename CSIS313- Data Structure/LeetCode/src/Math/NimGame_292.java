package Math;

public class NimGame_292 {
    public boolean canWinNim(int n) {
        return n%4==0 ? false : true;
     /* boolean[] dp = new boolean[n+1];
      if(n==0) return false;
      if(n < 4) return true;
      for(int i=1; i<=n; i++){
          if(i<4) dp[i]=true;
          else{
              dp[i] = !dp[i-1] || dp[i-2] || dp[i-3];
          }
      }
        return dp[n];  */
    }

}


/*
   num     winner
   1          T
   2          T
   3          T
   4          F
   5          T
   6          T
   7          T
   8          F


   1. brutal force

*/
