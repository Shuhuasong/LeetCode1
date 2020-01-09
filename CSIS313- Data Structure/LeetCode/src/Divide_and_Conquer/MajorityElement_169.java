package Divide_and_Conquer;

import java.util.*;

public class MajorityElement_169 {

    //  //Time Complexity: O(n), Space Complexity: O(n)
    /*public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; i++){
         if(!hash.containsKey(nums[i])){

            hash.put(nums[i],1);
         }else{
             int count = 1;
             hash.put(nums[i],count++);
         }
        }
        int maxValue = Collections.max(hash.values());
        int res = 0;
        for(int key : hash.keySet()){
            if(hash.get(key).equals(maxValue))
                res = key;
        }
        return res;
    }

     */


    /*
     Logic: if the array has the majority element, it will surely lie in
     the center of the array. since the majority element will be present >n/2 times;
     */


    //Time Complexity: O(n), Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
