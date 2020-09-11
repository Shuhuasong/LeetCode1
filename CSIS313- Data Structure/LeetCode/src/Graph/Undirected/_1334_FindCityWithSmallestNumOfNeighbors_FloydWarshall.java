package Graph.Undirected;

import java.util.Arrays;

public class _1334_FindCityWithSmallestNumOfNeighbors_FloydWarshall {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        int res = 0, minNum = n;
        for(int[] row : graph){
            Arrays.fill(row, 10001);
        }

        for(int[] e : edges){
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        for(int i=0; i<n; i++){
            graph[i][i] = 0;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(graph[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minNum){
                res = i;
                minNum = count;
            }
        }
        return res;
    }
}
