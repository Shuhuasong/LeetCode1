package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class N_QueensII_52 {
    //Time: O(n^2) Space: O(n)
    //run: 3ms (40%)
    public int res = 0;
    Set<Integer> col = new HashSet<>();//for Checking if there is a Queen on current column
    Set<Integer> diff= new HashSet<>();//for Checking if there is a Queen on current left-right diagonal
    Set<Integer> sum = new HashSet<>();//for Checking if there is a Queen on current right-left diagonal
    public int totalNQueens(int n) {
        if(n<=0) return  0;
        dfs(0, n);
        return res;
    }

    private void dfs( int row,int n){
        if(row==n){
            res++;
            return;
        }

        //iterate each row
        for(int i=0; i<n; i++){
            if(!col.contains(i) && !diff.contains(row-i) && !sum.contains(row+i)){
                col.add(i);
                diff.add(row-i);
                sum.add(row+i);
                dfs(row+1, n);
                col.remove(i);
                diff.remove(row-i);
                sum.remove(row+i);
            }
        }
    }
}
