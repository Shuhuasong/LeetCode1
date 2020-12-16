package LintCode.DynamicProgramming;

import java.sql.Time;

public class _741_CalculateMaximumValueII {

    /*
idea:
   dp[i][j] means the biggest value from ith character to jth character
   transtion function: dp[i][j] = max( dp[i][m] + dp[m+1][j], dp[i][m] * dp[m+1][j]); (i<=m < j)
0  1  3  9  12
0  1  3  9  12
0  0  2  6  8
0  0  0  3  4
0  0  0  0  1

dp[1][3] = max(dp[1][1] +/* dp[2][3])
dp[1][3] = max(dp[1][2] +/* dp[3][3])
*/
    //Time: O(L^2)
    public int maxValue(String str) {
        // write your code here
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = (int)str.charAt(i)-(int)'0';
        }
        //calculate the res on the different length position
        for(int l=2; l<=n; l++){ //l = the length of number, eg: [0,1],[1,2],[2,3]… 再计算[0,1,2],[1,2,3]…
            for(int i=0; i<n-l+1; i++){
                int j = i+l-1;
                for(int k=i; k<j; k++){
                    System.out.println( i + " "+ k + " "+ j);
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k+1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] * dp[k+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }
}
