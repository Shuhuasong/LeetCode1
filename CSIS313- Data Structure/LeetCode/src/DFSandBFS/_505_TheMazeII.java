package DFSandBFS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _505_TheMazeII {

    //Time: O(m *n log(m*n)) Space: O(mn)
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        if(maze==null || maze.length==0 || maze[0].length==0) return -1;
        int rows = maze.length, cols = maze[0].length;
        int[][] distance = new int[rows][cols];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);

        return distance[des[0]][des[1]]==Integer.MAX_VALUE ? -1 :  distance[des[0]][des[1]];
    }

    public void dijkstra(int[][] maze, int[] start, int[][] distance){
        int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        q.offer(new int[]{start[0], start[1], 0});

        while(!q.isEmpty()){
            int[] s = q.poll();
            //if(distance[s[0]][s[1]] < s[2]) continue;

            for(int[] dir : dirs){
                int x = s[0]+dir[0];
                int y = s[1]+dir[1];
                int step = 0;
                while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0){
                    x += dir[0];
                    y += dir[1];
                    step++;
                }

                if(distance[s[0]][s[1]]+step < distance[x-dir[0]][y-dir[1]]){
                    distance[x-dir[0]][y-dir[1]] = distance[s[0]][s[1]]+step;
                    q.add(new int[]{x-dir[0], y-dir[1],  distance[x-dir[0]][y-dir[1]]});
                }
            }
        }
    }

    /*

     //Time: O(m *n * max(m, n)) Space: O(mn)
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        if(maze==null || maze.length==0 || maze[0].length==0) return -1;
        int rows = maze.length, cols = maze[0].length;
        int[][] distance = new int[rows][cols];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);

        return distance[des[0]][des[1]]==Integer.MAX_VALUE ? -1 :  distance[des[0]][des[1]];
    }

    public void dijkstra(int[][] maze, int[] start, int[][] distance){
        int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        q.offer(new int[]{start[0], start[1], 0});

        while(!q.isEmpty()){
            int[] s = q.poll();
            if(distance[s[0]][s[1]] < s[2]) continue;

            for(int[] dir : dirs){
                int x = s[0]+dir[0];
                int y = s[1]+dir[1];
                int step = 0;
                while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0){
                    x += dir[0];
                    y += dir[1];
                    step++;
                }

                if(distance[s[0]][s[1]]+step < distance[x-dir[0]][y-dir[1]]){
                distance[x-dir[0]][y-dir[1]] = distance[s[0]][s[1]]+step;
                q.add(new int[]{x-dir[0], y-dir[1],  distance[x-dir[0]][y-dir[1]]});
              }
            }
        }
    }
     */
}
