package DynamicPrograming.TwoDimension;

public class _1277_CountSquareSubmatrix {
    public int countSquares(int[][] matrix){
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0) continue;
                if(i==0 || j==0){
                    res++;
                }else{
                    int min = Math.min(matrix[i-1][j-1],
                            Math.min(matrix[i-1][j], matrix[i][j-1]));
                    matrix[i][j] += min;
                    res += matrix[i][j];
                }
            }
        }
        return res;
    }
}

/*

Approach 1 : Bottom's Up DP
dp[i][j] represents the size of the largest square containing all ones with (i, j) as bottom-right corner.
If you think carefully
dp[i][j] will also represent the total number of squares containing all ones with (i, j) as bottom-right corner.

In bottom’s up DP we have to fill the dp array line by line.

Construct an array dp[][] for the given matrix[][].
a) Copy first row and first columns as it is from matrix[][] to dp[][], reason being for entries in first row and column only one square can exist with those entries being the bottom-right corner, so it only depends whether matrix[][] is 1 or 0.
b) For other entries, use following expressions to construct dp[][]
If matrix[i][j] is 1 then
dp[i][j] = min( dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
Else If matrix[i][j] is 0
dp[i][j] = 0
Find the sum of all entries in dp[][] and return.

 */