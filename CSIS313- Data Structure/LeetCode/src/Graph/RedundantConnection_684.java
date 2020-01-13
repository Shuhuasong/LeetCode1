package Graph;

public class RedundantConnection_684 {

    public int[] findRedundantConnection(int[][] edges) {
        // An array of node to keep track of the parent node of all nodes.
        // Union find strives to track the parent node of each node.

        int[] parent = new int[edges.length+1];

        // Perform the union find for each edge.
        // If a cycle is detected (false returned) then return that edge.


        for(int[] edge: edges){
            if(!union(edge, parent)){
                return edge;
            }
        }
        return new int[]{-1, -1}; //there is no cycle
    }
    // Find the parent node of each node in the edge.
    private boolean union(int[] edge, int[] parent){
        int x = find(parent, edge[0]);
        int y = find(parent, edge[1]);

        if(x==y) return false; //it means that x & y are both in the same cluster

        parent[y] = x;
        return true;
    }
    // find() recursively traverses over the parent array to find the top most parent for the given node's lineage.
    private int find(int[] parent, int node){
        if(parent[node]==0) return node; //path compressing
        // We can store the top-most parent node as we find it to avoid unnecessary traversal.
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }
}
