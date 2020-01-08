package Array;

import java.util.HashMap;
import java.util.Map;

// Time complexity: O(n), space Complexity: O(n)
public class TwoSum_1 {

  /*  public int[] twoSum(int[] nums, int target){;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int j=0; j<nums.length; j++){
            int complement = target-nums[j];
            if(map.containsKey(complement) && map.get(complement) != j){
                return new int[] {j, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two Sum solution");
    }

   */

  //// Time complexity: O(n), space Complexity: O(1)
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), j};
            } else
                map.put(nums[j], j);
        }
        throw new IllegalArgumentException("No two Sum solution");
    }

}
