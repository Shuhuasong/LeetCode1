package DynamicPrograming.TwoDimension;

public class _1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

/*

dp[i][j] : the common sequence [0---i] in text1, [0---j] in text2

0 1 2 3 4 5
a b c d e

0 1 2
a c e

   0   1   2  3   4   5
0
1     1   1  1   1   1
2     1   1  2   2   2
3     1   1  2   2   3

*/

