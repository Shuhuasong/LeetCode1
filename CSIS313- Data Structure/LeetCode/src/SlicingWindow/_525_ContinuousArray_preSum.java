package SlicingWindow;

import java.util.HashMap;
import java.util.Map;

public class _525_ContinuousArray_preSum {
    public int findMaxLength(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) nums[i]=-1;
        }
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        int sum = 0, maxLen = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum == 0){
                if(maxLen < i+1) maxLen = i+1; //if sum==0, it meaning from 0-i, there is equal number 0 and 1
            }else if(preSum.containsKey(sum)){
                maxLen = Math.max(maxLen, i-preSum.get(sum));
            }
            else{
                preSum.put(sum, i);
            }
        }
        return maxLen;
    }
}

/*
         0  1  2  3  4  5  6
nums = { 1, 1, 1, 0, 0, 1, 1} change 0 to -1
presum:  1  2  3  2  1  2  3  there is no 0, it dosen't meaning there is no such subarray
            <----->  this interval has a subarry, because sum=2 appear again
*/