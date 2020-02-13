package DFSandBFS;

public class NumberOfIsland_200 {
    //Time: O(n^2) Space: O(1)
    //run: 1ms (100%)
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int numIsland = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    numIsland += dfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    private int dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j]='0';//set the current as '0', so we don't need to revisit again
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        return 1;
    }
}
