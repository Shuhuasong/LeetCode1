package LintCode.TwoPointer;

import java.util.*;

public class _587_TwoSum_UniquePair {
   // Time: O(n) Space: O(n)
    public int twoSum6(int[] nums, int target) {
        // write your code here
        // write your code here
        if(nums==null || nums.length < 2) return 0;
        int n = nums.length, res = 0;
        Set<Integer> set  = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums){
            if(!map.containsKey(a)){
                map.put(a, 1);
            }
            map.put(a, map.get(a) + 1);
        }

        for(int k : map.keySet()){
            int comp = target - k;
            if(k < comp && map.containsKey(comp)){
                res++;
            }
            if(k==comp && map.get(k) >= 2){
                res++;
            }
        }
        return res;
    }
    // Java O(nlogn)
   /* public static int getUniquePairs(int[] nums, int target){
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        while (i < j){
            int sum = nums[i]+ nums[j];
            if (sum < target){
                i++;
            } else if (sum > target){
                j--;
            } else {
                ans++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i-1]){
                    i++;
                }
                while (i < j && nums[j] == nums[j+1]){
                    j--;
                }
            }
        }
        return ans;
    }

    */
}
