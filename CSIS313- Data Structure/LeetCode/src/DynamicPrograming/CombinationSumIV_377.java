package DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIV_377 {



  //Time Error
 /* public int count = 0;
    public int combinationSum4(int[] nums, int target) {
        //corner case
        if(nums==null || nums.length==0) return 0;
        dfs(nums, target, 0, new ArrayList<Integer>());
        return count;
    }

    private void dfs(int[] nums, int target, int curIndex, List<Integer> curList){
        if(target==0){
            count++;
            return;
        }
        if(target<0) return;

        for(int i=0; i<nums.length; i++){
            curList.add(nums[i]);
            dfs(nums, target-nums[i], curIndex, curList);
            curList.remove(curList.size()-1);
        }
    }

  */

    //Time: O(n), Space: O(n)
    //run:1ms (81%)
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=1; i<=target; i++){
            //update dp[i]
            for(int x : nums){
                if(i>=x){
                    dp[i] += dp[i-x];
                }
            }
        }
        return dp[target];
    }
}
