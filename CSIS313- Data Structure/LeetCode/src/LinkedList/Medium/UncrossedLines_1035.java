package LinkedList.Medium;

public class UncrossedLines_1035 {
    //run: 5ms (55%)
    //Time: O(n^2) Space: O(n^2)
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(A[i-1]==B[j-1]){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}
