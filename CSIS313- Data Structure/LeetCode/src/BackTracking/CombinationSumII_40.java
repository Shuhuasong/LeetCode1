package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    //Time: O(2^n) Space: O(n^2)
    //run: 3ms (81%)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0|| target<=0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] candidates, int target, int curIndex, List<List<Integer>> res, ArrayList<Integer> curList){
        if(target==0){
            res.add(new ArrayList<Integer>(curList));
        }else if(target > 0){
            for(int i=curIndex; i<candidates.length; i++){
                if(i != curIndex && candidates[i] == candidates[i-1]) continue;
                curList.add(candidates[i]);
                dfs(candidates, target-candidates[i], i+1, res, curList);
                curList.remove(curList.size()-1);

            }
        }
    }
}
