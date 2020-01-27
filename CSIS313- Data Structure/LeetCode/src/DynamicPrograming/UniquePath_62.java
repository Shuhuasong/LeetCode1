package DynamicPrograming;

public class UniquePath_62 {
   //Using dp
    //run time: 0ms (100%) 38.1MB
   public int uniquePaths(int m, int n) {
       int[] dp = new int[n];
       dp[0] = 1;
       for(int i= 0; i < m; i++){
           for(int j=1; j < n; j++){
               dp[j] += dp[j-1];
           }
       }
       return dp[n-1];
   }

   //Using Memo
    //run time: 1ms (12.85%) 38MB
 /*  public int uniquePaths(int m, int n) {
       int count[][] = new int[m][n];
       //initial
       for(int i=0; i < m; i++)
           count[i][0] = 1;
       for(int j=0; j < n; j++)
           count[0][j] = 1;
       //transfer function
       for(int i=1; i < m; i++){
           for(int j=1; j < n; j++){
               count[i][j] = count[i-1][j] + count[i][j];
           }
       }
       return count[m-1][n-1];
   }

  */


    //1-Recursion
    // Failed due to the run time error
 /*   public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }

  */


/*
    //Time Complexity: O(mn) Space: O(mn)
    public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0) return 0;
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i==1 && j==1) continue;
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

 */
}
