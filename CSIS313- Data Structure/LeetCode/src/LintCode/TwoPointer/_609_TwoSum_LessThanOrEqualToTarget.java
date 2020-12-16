package LintCode.TwoPointer;

public class _609_TwoSum_LessThanOrEqualToTarget {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        // write your code here
        if(nums==null) return 0;
        int res = 0;
        for(int r = 1,l = 0; r<nums.length && l<nums.length; r++){
            if(l<r && nums[l]+nums[r] <= target){
                res++;
            }
            if(r==nums.length-1){
                r=l+1;
                l++;
            }
        }
        return res;
    }
}
