package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//run Time: 29ms (83%)
//Time Complexity: O(n^2)
//Space Complexity: O(n)
public class ThreeSum_15 {
    /* method ; two pointer
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){ //use two pointer
            if(i>0 && nums[i] == nums[i-1]) continue; //repeat [-1,-1, 0, 1,2,3,4]
            int low = i+1, high = nums.length-1, sum = 0 - nums[i];
            while(low<high){
                if(nums[low] + nums[high]==sum){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low+1]) low++; //skip repetition
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                }else if(nums[low]+nums[high] < sum){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }

     */

    //Time Complexity: O(n^2)
  //Runtime : 48ms (38%)
    public List<List<Integer>> threeSum(int[] nums) {
      ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
      if(nums == null || nums.length <= 2) return res;
      int n = nums.length;
      int i = 0;
      Arrays.sort(nums);
      while(i<n-2){
          int base = nums[i];
          int left = i + 1;
          int right = n -1;

          while(left<right) {
              int sum = base + nums[left] + nums[right];
              if(sum==0){
                  LinkedList<Integer> list = new LinkedList<Integer>();
                  list.add(base);
                  list.add(nums[left]);
                  list.add(nums[right]);
                  res.add(list);
                  left = moveRight(nums, left+1);
                  right = moveLeft(nums, right-1);
              }else if(sum > 0){
                  right = moveLeft(nums, right-1);
              }else if(sum < 0){
                  left = moveRight(nums, left+1);
              }
          }
          i = moveRight(nums, i+1);
      }
      return res;
    }

    public int moveLeft(int[]  nums, int right){
        while(right == nums.length-1 || (right >= 0 && nums[right]==nums[right+1])){
            right--;
        }
        return right;
    }

    public int moveRight(int[] nums, int left){
        while(left==0 || (left < nums.length && nums[left]==nums[left-1])){
            left++;
        }
        return left;
    }


}
