package Array;

import java.util.Arrays;

class ThreeSumCloses_16 {
    //Time: O(n) Space: O(n)
    // run : 3ms (98%)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int tempSum = nums[i] + nums[left]+ nums[right];
                int tempDiff = Math.abs(tempSum-target);
                if(tempDiff<diff){
                    diff = tempDiff;
                    sum = tempSum;
                }
                if(tempSum < target) left++;
                else if(tempSum > target) right--;
                else return target;
            }
        }
        return sum;
    }
}


/*
 nums = { -1,  2,   1,  -4}
           |   |         |
           i   left     right
*/
