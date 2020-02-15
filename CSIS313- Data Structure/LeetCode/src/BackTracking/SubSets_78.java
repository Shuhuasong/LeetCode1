package BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSets_78 {
    //Time: O(n)  Spase: O(n)
    //run: 1ms (53%)
   /* public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return null;
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(nums, 0, res, new LinkedList<Integer>());
        return res;
    }

    private void helper(int[] nums, int curIndex, LinkedList<List<Integer>> res, List<Integer> curList ){
        res.add(new LinkedList<Integer>(curList));
        for(int i=curIndex; i<nums.length; i++){
            curList.add(nums[i]);
            helper(nums, i+1, res, curList);
            curList.remove(curList.size()-1);
        }
    }

    */


    //Time: O(n)  Spase: O(n)
    //run: 1ms (53%)
  /*  public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return null;

        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(nums, 0, res, new LinkedList<Integer>());
        return res;
    }
    private void helper(int[]  nums, int curIndex, LinkedList<List<Integer>> res, List<Integer> curList){
        if(curIndex==nums.length){ //the curIndex has reach the outside of array, stop
            res.add(new LinkedList<Integer>(curList)); //it mean the curList is a validate subset
        }else{
            helper(nums, curIndex+1, res, curList);//not add the current data
            curList.add(nums[curIndex]);//add the current data
            helper(nums, curIndex+1, res, curList);//use the new curIndex to call the helper function
            curList.remove(curList.size()-1);
            //when dfs go to 123, if we need to go back to continue tracking, we need to delete 3
        }
    }

   */

    //Time: O(n)  Spase: O(n)
    //run: 1ms (53%)
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return null;
        Arrays.sort(nums);
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        dfs(nums, 0, res, new LinkedList<Integer>());
        return res;
    }
    //definition of DFS , break down
    private void dfs(int[]  nums, int curIndex, LinkedList<List<Integer>> res, List<Integer> curList){
        //deep copy
        res.add(new LinkedList<Integer>(curList));//res.add(curList) shadow copy
        for(int i = curIndex; i<nums.length; i++){
            curList.add(nums[i]);
            dfs(nums, i+1, res, curList);
            curList.remove(curList.size()-1);
        }
    }
}
