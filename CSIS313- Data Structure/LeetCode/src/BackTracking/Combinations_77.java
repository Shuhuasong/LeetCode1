package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
    //Time: O(nlogn) Spase: O(n)
    //run: 26ms (39%)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if(k > n) return res;
        dfs(n, k, 1, res, new LinkedList<Integer>());
        return res;
    }

    private void dfs(int n, int k, int curIndex,  List<List<Integer>> res, List<Integer> curList){

        for(int i=curIndex; i<=n; i++){
            curList.add(i);
            dfs(n, k, i+1, res, curList);
            curList.remove(curList.size()-1);
        }

        if(curList.size()==k){
            res.add(new LinkedList<Integer>(curList));
            return;
        }
    }
}
