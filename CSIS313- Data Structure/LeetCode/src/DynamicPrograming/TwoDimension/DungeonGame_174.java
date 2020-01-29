package DynamicPrograming.TwoDimension;

import java.util.Arrays;

public class DungeonGame_174 {
    //Time Complexity: O(mn) Space: O(mn)
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null && dungeon.length==0) return 0;

        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows+1][cols+1];

        for(int i=0; i<=rows; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[rows][cols-1] = 1;
        dp[rows-1][cols] = 1;
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){
                int min = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];
                dp[i][j] = min <=0 ? 1 : min;
            }
        }
        return  dp[0][0];
    }
}
