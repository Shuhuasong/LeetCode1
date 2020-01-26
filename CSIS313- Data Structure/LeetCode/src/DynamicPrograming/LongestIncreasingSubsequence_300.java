package DynamicPrograming;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {

    //Time Complexity: O(nlogn)
    //space : O(n)
    //run time: 21 ms (18%) 39.7MB
  /*  public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int n = nums.length;
        int[] maxLength = new int[n];


        for(int i=0; i<n; i++){
            maxLength[i] = 1; //Arrays.fill(n, 1);
        }
        int maxSofar = 1;
        for(int i=1; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j] ){
                    maxLength[i] = Math.max(maxLength[i], maxLength[j]+1);
                }
            }

            maxSofar = Math.max(maxSofar, maxLength[i]);
        }
        return maxSofar;
    }

   */

    //Time Complexity: O(nlogn)
    //space : O(n)
    //run time: 10 ms (44%) 37.7MB
 /*   public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;

        for(int i=0; i<n; i++){
            int len = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    len = Math.max(len, dp[j]+1);
                }
            }
            dp[i] = len;
            if(dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        return maxLen;
    }
    
  */


    //Time Complexity: O(nlogn)
    //space : O(n)
    //run time: 0 ms (100%) 37.9MB
    //Binary Search
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        //
        int len = 0;
        for(int num : nums){
            int index = Arrays.binarySearch(dp, 0, len, num);
            //return  pos = (-insertPoint - 1)
            // insertPoint = -(pos+1)
            if(index < 0){
                index = -(index + 1);
            }

            dp[index] = num;

            if(index == len){
                len++;
            }
        }
        return len;
    }
}
