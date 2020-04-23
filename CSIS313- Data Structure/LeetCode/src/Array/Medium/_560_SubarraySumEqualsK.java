package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class _560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();

        int count = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(preSum.containsKey(sum-k)){
                count += preSum.get(sum-k);
            }

            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);

            if(sum==k) count++;
        }
        return count;
    }
}
