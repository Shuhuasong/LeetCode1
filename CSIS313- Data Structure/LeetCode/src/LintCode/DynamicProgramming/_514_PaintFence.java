package LintCode.DynamicProgramming;

public class _514_PaintFence {

    public int numWays(int n, int k){
        int[] dp = {0, k, k*k, 0};
        if(n<=2){
            return dp[n];
        }
        for(int i=2; i<n; i++){
            dp[3] = (k-1) * (dp[1] + dp[2]);
            dp[2] = dp[3];
            dp[1] = dp[2];
        }
        return dp[3];
    }

    /*
     public int numWays(int n, int k) {
        // write your code here
      if(n==0) return 0;
      if(n==1) return k;
      int same = k;
      int diff = k * (k-1);
      for(int i=3; i<=n; i++){
          int temp = diff;
          diff = (same + diff) * (k-1);  //when the current post color is different with previous one
          same = temp * 1;   //when the curren post color is the same with previous one
      }
      return same + diff;
    }

          same = k*1 , when the curren post color is the same with previous one
          different = k * (k-1)  when the current post color is different with previous one
          2 post answer: same + different = k + k * (k-1)
     */
}
/*
采用动态规划的思想
dp[i]=(k-1)×(dp[i-1]+dp[i-2])
  dp[i-1]×(k-1)代表当前格子的颜色和前一个不同的方案,
  dp[i-2]×(k-1)代表当前格子的颜色和前一个相同的方案
*/