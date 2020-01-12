package Divide_and_Conquer;

import java.util.*;

public class FindKthSmall_719 {

    //Time Complexity: O(n)
    public int smallestDistancePair(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n-1]-nums[0];
        while(left < right){
            int mid = (left+right)/2;
            int j = 0;
            int count = 0;
            for(int i=0; i<n; i++){
                while(j<n && nums[j]-nums[i]<=mid) j++;
                count += j-i-1;
            }
            if(count < k ){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return left;
    }

    //run time: 325ms, Time Complexity: O(n^2)
   /* public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        //create a new arrau
        int[] count = new int[nums[nums.length-1]+1];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++)
                count[nums[j]-nums[i]]++;
        }

        int number = 0;
        for(int i=0; i<count.length; i++){
            number += count[i];
            if(number >= k) return i;
        }
        return -1;
    }

    */

  /*  public int smallestDistancePair(int[] nums, int k) {
      List<Integer> list = new ArrayList<>();
      for(int i=0; i<nums.length; i++){
          for(int j=i+1; j<nums.length; j++ ){
              int len = Math.abs((nums[i]-nums[j]));
              if (!list.contains(len)){
                  list.add(len);
              }
          }
      }
        Collections.sort(list);
      return list.get(k);
    }

   */
}
