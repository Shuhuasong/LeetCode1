package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null && nums.length==0) return res;
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<List<Integer>> res, ArrayList<Integer> curList){
        if(curList.size()==nums.length){
            res.add(new ArrayList<Integer>(curList));
            return;
        }else{
            for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;

                used[i]=true;
                curList.add(nums[i]);
                dfs(nums, used, res, curList);
                used[i]=false;
                curList.remove(curList.size()-1);
            }
        }
    }
}
