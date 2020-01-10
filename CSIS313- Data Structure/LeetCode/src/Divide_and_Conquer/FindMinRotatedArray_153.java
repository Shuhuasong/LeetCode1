package Divide_and_Conquer;

public class FindMinRotatedArray_153 {


    //run time: 4ms (>76.16%)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
  /*
    public int findMin(int[] nums) {
     for(int i=0; i<nums.length; i++){
         if(nums[i]<nums[i+1])
             return nums[i];
     }
     return -1;
    }

   */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left<right){
            int mid = left + (right-1)/2;
            if((nums[mid]>nums[left])){ //left side is sorted
                left = mid;
            }else{
                right = mid;
            }
        }
        return Math.min(nums[0], Math.min(nums[left], nums[right]));
    }
}
