package DynamicPrograming.TwoDimension;

public class _1039_MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp=new int[n][n];
        //Arrays.fill(dp, (Integer.MAX_VALUE)/3);

        for(int len=2; len<n; len++){
            for(int i=0; i<n-len; i++){
                int j = i+len;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+ A[i]*A[k]*A[j]+dp[k][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

/*
len: the length of partition
i : the start of partition
j : the end of partition
k : the vertex

     i 1   2
j 6           3 k
      5   4

*/
