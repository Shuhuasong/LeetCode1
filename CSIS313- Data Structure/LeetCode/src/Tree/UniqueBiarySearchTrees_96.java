package Tree;

public class UniqueBiarySearchTrees_96 {
    //Time: O(n^2)
    // Space: O(n)
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        //We will solve every subproblem from 2 to our target subproblem n

        for(int i=2; i<=n; i++){
            //All possible unique left BST's count is G[j - 1] if we plant at i.
            //All possible unique right BST's count is G[i - j] if we plant at i
            for(int j=1; j<=i; j++){
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
