package DynamicPrograming;


/*
Solution:
1. check if the sum is even, if it is odd, it means the two set of sum cannot be the same
2. DP : (1)BackTracking: Add the number to find if there is a sum = sum/2;
        (2) DP: Bottom-up: dp[n] -> true
                           dp[n-nums[0]] -> true
 */

public class _416_PartitionEqualSubsetSum {

 /*   //BackTracking: O(n) Space: O(1)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        if(sum%2 != 0) return false;
        sum = sum/2;//this is the target, if we can find there is a sum/2, it means anthoer part set of number is also sum/2
        return helper(nums, 0, sum);
    }

    public boolean helper(int[] nums, int index, int target){
        if(target==0) return true; //it means we have found this target
        if(index==nums.length || target<0) return false;
        if(helper(nums, index+1, target-nums[index])) return true; //in this branch, it means we can find a path that is sum/2
        int j = index+1;                    //if we can't find, we need to start from other number to find a solution
        while(j< nums.length && nums[index]==nums[j]){ //we skip the duplicate number, to start a different number
            j++;
        }
        return helper(nums, j, target); //we don't need to substruct target here, because we just change a start index
    }
  */

    //DP-Knapsack: O(n) Space: O(1)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a : nums){
            sum += a;
        }
        if(sum%2 != 0) return false;
        sum = sum/2;//this is the target
        boolean[] dp = new boolean[sum+1];//dp[i], sum = i, to see if we can find a sum from array
        dp[0] = true;
        for(int num : nums){//for every num, we can use or don't use
            for(int j=sum; j>=0; j--){
                if(j>=num){
                    dp[j] = dp[j] || dp[j-num]; //it means we don't choose this num || we choose this num
                }
            }
        }
        return dp[sum];
    }
}



