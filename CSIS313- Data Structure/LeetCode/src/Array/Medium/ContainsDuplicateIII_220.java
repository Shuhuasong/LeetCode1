package Array.Medium;

import java.util.TreeSet;

public class ContainsDuplicateIII_220 {
    //Time: O(nlog n) Space: O(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i=0; i<nums.length; i++){
            Long floor = set.floor((long) nums[i]);//floor: return the maximum value that is <= nums[i]
            if(floor != null && nums[i]-floor <= t){
                return true;//we find the pair
            }

            Long ceil = set.ceiling((long) nums[i]); //ceil: return the minimum value that is >= nums[i]
            if(ceil != null && ceil-nums[i] <= t ){
                return true;
            }

            set.add((long) nums[i]); //add it if we don't find
            if(set.size() > k){
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }

    /*
    Idea: loop through this array, keep adding each element into the TreeSet, also keep an eye on
         * the size of the TreeSet, if it's greater than the required distance of k, then we remove the
         * left-most or oldest one from the set. For each element, we get the current floor and the
         * current ceiling and see if it works, if it does, then we return true immediately, otherwise,
         * we continue. Return false when we finished the loop.

    */
}
