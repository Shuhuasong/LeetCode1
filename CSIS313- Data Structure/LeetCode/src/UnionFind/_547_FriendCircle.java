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
}
