package SlicingWindow;

import java.util.HashMap;
import java.util.Map;

public class _930_BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] A, int S){
        int n = A.length, count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : A){
            sum += num;
            if(map.containsKey(sum-S)) count += map.get(sum-S);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}


/* Can be used for array with positive or negative number
          0  1  2  3  4  5
   A =  { 1, 0, 1, 0, 1 }
preSum    0  1  1  2  2  3

when index=4, the preSum = 3, we need to look for the subarray with sum (prSum-S), in order to get the subarray like {0,1,0,1} or {1,0,1}

*/