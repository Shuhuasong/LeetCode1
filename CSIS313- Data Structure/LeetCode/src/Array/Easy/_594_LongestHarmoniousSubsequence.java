package Array.Easy;

import java.util.HashMap;

public class _594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int num : map.keySet()){
            if(map.containsKey(num+1)){
                max = Math.max(max, map.get(num)+map.get(num+1));
            }
        }
        return max;
    }

    /*
     public int findLHS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right]-nums[left] < 1) right++;
            else if(nums[right]-nums[left]==1) {
                res = Math.max(res, right-left+1);
                right++;
            }else{
                left++;
            }
        }
        return res;
    }
     */
}
