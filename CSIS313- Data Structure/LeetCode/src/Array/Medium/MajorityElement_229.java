package Array.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_229 {
    //Time: O(n) Space: O(2k)=O(1)
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        if(nums==null || nums.length==0) return res;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int times = nums.length/3;

        for(int key : map.keySet()){
            if(map.get(key)>times){
                res.add(key);
            }
        }
        return res;
    }
}
