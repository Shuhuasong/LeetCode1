package Array;

public class CountServers1267 {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans += (rows[i]>1 || cols[j]>1) ? grid[i][j] : 0;
            }
        }
        return ans;
    }
}
