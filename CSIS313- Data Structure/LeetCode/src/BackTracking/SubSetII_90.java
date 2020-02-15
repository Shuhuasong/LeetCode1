package BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSetII_90 {
      //Time: O(n) Space: O(n)
        //run: 2ms (28%)
      /*  public List<List<Integer>> subsetsWithDup(int[] nums) {
            if(nums==null || nums.length==0) return null;
            Arrays.sort(nums);
            LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
            helper(nums, 0, true, res, new LinkedList<Integer>());
            return res;
        }

        private void helper(int[] nums, int curIndex, boolean taken, LinkedList<List<Integer>> res, List<Integer> curList){
            if(curIndex==nums.length){
                res.add(new LinkedList<Integer>(curList));
            }else{
                helper(nums, curIndex+1, false, res, curList);
                if(taken || nums[curIndex-1] != nums[curIndex]){
                    curList.add(nums[curIndex]);
                    helper(nums, curIndex+1, true, res, curList);
                    curList.remove(curList.size()-1);
                }
            }
        }


       */

    //Time: O(n) Space: O(n)
    //run: 2ms (28%)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null || nums.length==0) return null;
        Arrays.sort(nums);
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        dfs(nums, 0, res, new LinkedList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int curIndex,  LinkedList<List<Integer>> res, List<Integer> curList){
        res.add(new LinkedList<Integer>(curList));
        for(int i = curIndex; i< nums.length; i++){
            if(i > curIndex && nums[i] == nums[i-1]) continue; //skip this for loop
            curList.add(nums[i]);
            dfs(nums, i+1, res, curList);
            curList.remove(curList.size()-1);
        }
    }

}
