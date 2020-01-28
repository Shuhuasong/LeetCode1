package DynamicPrograming;

import java.util.Arrays;

public class PerfectSquares_279 {
    //32ms (43%)
    //n = 12
    //1 + minSquare(12-1)
    //4 + minSquare(12 - 4) = 4 + 1 + minSquare(8-1)
    //                      = 4 + 4 + minSquare(8-4)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j * j <=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
