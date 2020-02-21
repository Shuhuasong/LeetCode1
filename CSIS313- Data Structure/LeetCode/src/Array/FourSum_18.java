package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {


    //Time: O(n^3) Space: O(n^3)
    //run: 11ms (85%)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums==null || nums.length < 4) return res;

        for(int i=0; i<nums.length-3; i++){
            if(i != 0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        List<Integer> curList = new ArrayList<>();
                        curList.add(nums[i]);
                        curList.add(nums[j]);
                        curList.add(nums[left]);
                        curList.add(nums[right]);

                        res.add(curList);

                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }


                }

            }
        }
        return res;
    }
}
