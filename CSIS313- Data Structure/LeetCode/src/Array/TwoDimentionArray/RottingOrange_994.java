package Array.TwoDimentionArray;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange_994 {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1,0 ,-1, 0};
        int rows = grid.length;
        int cols = grid[0].length;
        int cntFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        if(cntFresh==0) return 0;
        int res = 0;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] point = q.poll();
                for(int k=0; k<4; k++){
                    int x = point[0]+dx[k];
                    int y = point[1]+dy[k];
                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]==0 || grid[x][y]==2) continue;
                    //infected fresh orange
                    grid[x][y]=2;
                    q.offer(new int[]{x, y});
                    cntFresh--;
                }
            }
        }
        return  (cntFresh==0) ? res-1 : -1;
    }
}
