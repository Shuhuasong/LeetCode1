package DynamicPrograming.TwoDimension;

public class MaximalSquare_221 {
    //run time: 4ms (94.89%)
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];

        int max = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }

/*
    //run time: 7ms (18.53%)
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int rows = matrix.length;
        int ans = 0;
        if(rows<=0) return ans;
        int cols = matrix[0].length;

        for(int i=0; i<rows; i++)
            if(matrix[i][0]=='1') ans = 1;
        if(ans<1)
            for(int j=0; j<cols; j++)
                if(matrix[0][j]=='1') ans = 1;


        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][j]=='1'){
                    int up = matrix[i-1][j]-'0';
                    int left = matrix[i][j-1]-'0';
                    int ul = matrix[i-1][j-1]-'0';

                    int temp = Math.min(up, Math.min(left, ul)) + 1;
                    ans = Math.max(ans, temp);
                    matrix[i][j] =(char)(temp+'0');
                }
            }
        }
        return ans * ans;
    }

 */


 /*
  //run time: 7ms (18.43%)
    public int maximalSquare(char[][] matrix) {
       int max = 0;
       for(int i=0; i<matrix.length; i++){
           for(int j=0; j<matrix[0].length; j++){
               if(matrix[i][j]=='1'){
                   if(i>0 && j>0 && matrix[i-1][j]>48 && matrix[i][j-1]>48 && matrix[i-1][j-1]>48){
                       matrix[i][j] = (char)(Math.min(matrix[i-1][j], Math.min(matrix[i][j-1],matrix[i-1][j-1]))+1);

                   }
                    max = Math.max(max, matrix[i][j]);
               }
           }
       }
        return max==0 ? 0 : (int)Math.pow(max-48, 2);
    }
  */
}
