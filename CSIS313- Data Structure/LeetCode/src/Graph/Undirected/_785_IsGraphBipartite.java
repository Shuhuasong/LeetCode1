package Graph.Undirected;

public class _785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0; i<n; i++){
            //the cur node without color or can't be colored
            if(colors[i]==0 && !dfs(graph, colors, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color){
        //The node have colored
        if(colors[node]!=0){
            return colors[node] == color;
        }
        colors[node] = color;
        //The cur node has not been colored
        for(int j : graph[node]){
            if(colors[j]==color) return false;
            if(colors[j]==0 && !dfs(graph, colors, j, -color)) return false;
        }
        return true;
    }
}
