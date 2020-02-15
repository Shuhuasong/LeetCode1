package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N_Queens_51 {
    //Time: O(n^2) Space: O(n^2)
    //run: 4ms (63%)
    Set<Integer> col = new HashSet<>();
    Set<Integer> diff = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //corner case
        if(n<=0) return res;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        dfs(n, 0, res, board);
        return res;
    }

    private void dfs(int n, int level, List<List<String>> res, char[][] board){
        //the exit of recursion
        if(level==n){// have find a validate solution, add it to result
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(String.valueOf(board[i]));
            }
            res.add(temp);
        }

        for(int i=0; i<n; i++){
            if(!col.contains(i) && !diff.contains(level-i) && !sum.contains(level+i)){ //level = row
                col.add(i);
                diff.add(level-i);
                sum.add(level+i);
                board[level][i]='Q';
                dfs(n, level+1, res, board);
                board[level][i]='.';
                col.remove(i);
                diff.remove(level-i);
                sum.remove(level+i);
            }
        }
    }
}
