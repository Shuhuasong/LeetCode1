package LintCode.DynamicProgramming;

public class _515_PaintHouse {
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        if(n==0) return 0;

        int[][] dp = new int[n][3];

        for(int i=0; i<3; i++){
            dp[0][i] = costs[0][i];
            // System.out.print(dp[0][i] + "  ");
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(j!=k){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + costs[i][j]);
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

/*  滚动数组
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        if(n==0) return 0;

        int[][] dp = new int[2][3];

        int old = 0, now = 0;
        dp[now][0] = dp[now][1] = dp[now][2] = 0;

        for(int i=1; i<=n; i++){
            old = now;
            System.out.print( " now1 = " + now);
            now = 1-now;

            for(int j=0; j<3; j++){
                dp[now][j] = Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(j!=k){
                        System.out.print( " now2 = " + now);
                        dp[now][j] = Math.min(dp[now][j], dp[old][k] + costs[i-1][j]);
                    }
                }
            }

            for(int x=0; x<2; x++){
                for(int y=0; y<3; y++){
                    System.out.print(dp[x][y] + " ");
                }
                System.out.println();
            }
        }
        int result = dp[now][0];
        if(dp[now][1] < result){
            result = dp[now][1];
        }
        if(dp[now][2] < result){
            result = dp[now][2];
        }
        return result;
    }
    */
}

/*
dp[i][j] means the minimum sum for ith house with j color
initial status: dp[0][i] = costs[0][i];
14   2   11
13   25   7
21   10   23
算法思路
dp[i][j]表示第i幢房子涂j的颜色最小的花费总和，即从前一幢房子的状态dp[i-1][k] (k != j)中选一个不同颜色且最小的再加上给第i幢房子涂j颜色的costs。
代码思路
初始化状态dp[0][i]=costs[0][i]

从左往右遍历每一幢房子，计算到该幢房子涂每种颜色的最小花费，状态转移方程是dp[i][j] = min{dp[i-1][k] +costs[i][j]} (k != j)

答案为到最后一幢房子涂每种颜色花费中的最小值，即min(dp[n-1][k]),k=0,1,2

复杂度分析
N表示房子的幢数，即costs数组长度

空间复杂度：O(1)

时间复杂度：O(N)

优化
滚动存储状态，可以将空间复杂度从O(N)优化到O(1)。
*/
