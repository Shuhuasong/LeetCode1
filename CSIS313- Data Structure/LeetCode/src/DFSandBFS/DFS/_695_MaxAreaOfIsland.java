package DFSandBFS.DFS;

public class _695_MaxAreaOfIsland {
    //Time: O(m*n) Space: O(1)
    int rows, cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int res = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                res = Math.max(res, dfs(grid,i,j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0){
            return 0;
        }

        grid[i][j] = 0;//set cur val as 0, to avoid count again
        return 1 + dfs(grid, i+1, j)
                + dfs(grid, i-1, j)
                + dfs(grid, i, j+1)
                + dfs(grid, i, j-1);
    }
}

/*
floorKey(K key): return the greatest key less than or equal to given key from the paramter:   result <= key
ceilingKey(K key): return the least key greater or equal to the given key : result >= key
 */