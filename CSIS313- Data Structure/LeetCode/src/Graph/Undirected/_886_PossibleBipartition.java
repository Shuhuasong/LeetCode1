package Graph.Undirected;

import java.util.ArrayList;
import java.util.List;

public class _886_PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] g = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            g[i] = new ArrayList<>();
        }

        for(int[] d : dislikes){
            g[d[0]].add(d[1]);
            g[d[1]].add(d[0]);
        }

        int[] colors = new int[N+1];
        for(int i=1; i<=N; i++){
            if(colors[i]==0 && !dfs(g, colors, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] g, int[] colors, int node, int color){
        colors[node] = color;
        for(int i : g[node]){
            if(colors[i]==color) return false;
            if(colors[i]==0 && !dfs(g, colors, i, -color)) return false;
        }
        return true;
    }
}


/*
1. Build graph
2. DFS/BFS
*/