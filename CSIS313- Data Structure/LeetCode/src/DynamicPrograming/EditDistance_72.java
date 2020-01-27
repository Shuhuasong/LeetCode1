package DynamicPrograming;

public class EditDistance_72 {
    //run time: 15ms (7.6%)  41.9MB
    //Time Complexity: O(mn); Space: O(mn)


 /*   public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            dp[i][0] = i;
        for(int i=1; i<=n; i++)
            dp[0][i] = i;
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){

                if(word1.charAt(i)==word2.charAt(j))
                    dp[i+1][j+1] = dp[i][j];
                else {
                    int a = dp[i][j];
                    int b = dp[i][j+1];
                    int c = dp[i+1][j];
                    dp[i+1][j+1] = a < b ? (a<c ? a : c) : (b<c ? b : c);
                    dp[i+1][j+1]++;
                }

                 // System.out.println(dp[i][j]);
            }

        }
        return dp[m][n];
    }

  */

 //run time: 13 ms (8.64%)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0] = i;
        for(int j=0; j<=n; j++) dp[0][j] = j;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //if last character are the same, ignore last char
                //and recur for remaining string
                if(word1.charAt(i)==word2.charAt(j))
                    dp[i+1][j+1] = dp[i][j];
                else
                    //if last character are different, consider all possibilites ans find minimum
                    dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
            }
        }
        return dp[m][n];
    }
}
