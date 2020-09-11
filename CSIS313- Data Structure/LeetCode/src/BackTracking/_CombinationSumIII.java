package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //if(k==0 || n==0) return res;
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        dfs(k, n, 0, curList, res);
        return res;
    }

    public void dfs(int k, int remain, int start, LinkedList<Integer> curList,  List<List<Integer>> res){
        if(remain == 0 && curList.size()==k){
            res.add(new ArrayList<Integer>(curList));
            return;
        }else if(remain < 0 || curList.size()==k){
            return;
        }

        for(int i=start; i<9; i++){
            //remain -= i;
            curList.add(i+1);
            System.out.print(i + " ");
            dfs(k,  remain-i-1, i+1, curList,res);
            curList.removeLast();
        }
    }

}
