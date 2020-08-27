package TwoPointer.medium;
/*
idea: Here we want to find the maximum number of consecutive 1s,
 so we can calculate the number of 0s(count), when count>1,
 it means we have one result, then we compare this result with previous one
*/
public class _487_MaxConsecutiveOnesII {
    //Time: O(n) Space: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i=0, count = 0; //count the number of zero
        int res = 0;
        for(int j=0; j<n; j++){
            if(nums[j]==0){
                count++;
            }
            while(count>1){
                res = Math.max(res, j-i);
                count -= (nums[i]==0 ? 1 : 0);
                i++; //increase the start pointer to narrow the window
            }
            if(count<=1 && j==n-1){//for the case Input: [1,0,1,1], when count<=1
                res = Math.max(res, j-i+1);
            }
        }
        return res;
    }
}
