package UnionFind;

public class _547_FriendCircle {
    class UnionFind{
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n){
            count = n;
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        //path compression
        public int find(int p){
            if(p!=parent[p]){
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int x, int y){
            int px = find(x); //find the root of x
            int py = find(y);
            if(px==py) return;
            if(rank[py] > rank[px]){ parent[px]=py; }
            else{
                parent[py] = px;
                if(rank[px]==rank[py]){
                    rank[x]++;
                }
            }
            count--;
        }

        public int count() { return count; }
    }
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(M[i][j]==1) uf.union(i,j);
            }
        }
        return uf.count();
    }

    /*
     Union Find- Without Path Compression
      //Time: O(n^3)  Space: O(n)
    //find root
    public int find(int[] parent, int i){
        if(parent[i] == -1){
            return i;//when this node is still a parent itslef(no parent, a independent tree), we return itself
        }
        return find(parent, parent[i]);

    }

    public void union(int[] parent, int x, int y){
        int xp = find(parent, x);
        int yp = find(parent, y);
        if(xp != yp){
            parent[xp] = yp;
        }
    }

    public int findCircleNum(int[][] M) {
       int n = M.length;
       int[] parent = new int[n];
       Arrays.fill(parent, -1); //Initialize very node as their own parent
       for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               if(M[i][j]==1 && i!=j){
                   union(parent, i, j);
               }
           }
       }
       int count = 0; //Why we count the number of -1 as the result?
       for(int i=0; i<n; i++){ //because the -1 means the parent(root) in this array,
           if(parent[i]==-1){ //the number of root(parent) == the number of independant tree
               count++;
           }
       }
        return count;
    }
     */

    /*
    Solution: View matrix as the Adajcency Matrix,
    problem reduces to the problem of finding the number of connected components
    in an undirected graph

    DFS : If we view this matrix M as the adjancency matrix of a graph with three component,
     the components which are connected can be reached starting from any single node of the
     connected group. Thus, to find the number of connected components, we start from every
     node which isn't visited right now and apply DFS starting with it. We increment the
     countcount of connected components for every new starting node.
     //Time: O(n^2)  Space: O(n)


    public int findCircleNum(int[][] M) {
      int n = M.length;
      int ans = 0;
      int[] visited = new int[n];
      for(int i=0; i < n; i++){
          if(visited[i]==0){
              dfs(M, visited, i);
              ans++;
          }
       }
        return ans;
    }

    public void dfs(int[][] M, int[] visited, int i){
        for(int j=0; j<M.length; j++){
            if(M[i][j]==1 && visited[j]==0){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
     */

    /*
    BFS:
    use graph algorithms easily to find the number of connected components. This approach makes
    use of Breadth First Search for a graph.


     */
}
