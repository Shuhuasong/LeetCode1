package DFSandBFS.DFS;

public class _200_NumberOfIslands {
    //Time: O(n^2) Space: O(1)
    //run: 1ms (100%)
    int res = 0;
    public int numIslands(char[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    res += dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private int dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }
}
