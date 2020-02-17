package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    //Time: O(2^n)  Space(n^2)
    //run: 4ms (64%)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0 || target <= 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] candidates, int target, int curIndex, List<List<Integer>> res, ArrayList<Integer> curList){
        if(target == 0){
            res.add(new ArrayList<Integer>(curList));
        }else if(target > 0){
            for(int i=curIndex; i<candidates.length; i++){
                if(candidates[i] > target) break;//used to improve performance
                curList.add(candidates[i]);
                dfs(candidates, target-candidates[i], i, res, curList);
                curList.remove(curList.size()-1);
            }
        }
    }
}
