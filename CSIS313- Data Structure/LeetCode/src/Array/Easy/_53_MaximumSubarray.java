package Array.Easy;

public class _53_MaximumSubarray {
    //Greedy--Pick the locally optimal move at each step, and that will lead to the globally optimal solution.
    // Time: O(n) Space: O(1)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int curSum = nums[0];//current local maximum sum
        int maxSum = nums[0];//global maximum sum seem so far

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }


    /*
     //DP--Time: O(n) Space: O(1)
    public int maxSubArray(int[] nums) {
       if(nums==null || nums.length==0) return -1;
     int maxToCur = nums[0], sum = nums[0];

     for(int i=1; i<nums.length; i++){
         maxToCur += nums[i];
         if(maxToCur < nums[i]){
             maxToCur = nums[i];
         }
         sum = Math.max(sum, maxToCur);
       }
        return sum;
    }
     */
}



/*
DP idea:
    when we encounter a new value, we either take it or not take is
    if we take it, we add this value with previous result and compare with the curent
    value:
    previous + curVal < curVal, we only take curVal single element
    previous + curVal > curVal, we set the curVal = previous + curVal


    nums = [ -2,  1,  -3,  4,  -1,  2,  1,  -5,  4]
curSum       -2   1   -2   4   3    5   6    1   5
maxSum       -2   1   1    4   4    5   6    6   6
*/