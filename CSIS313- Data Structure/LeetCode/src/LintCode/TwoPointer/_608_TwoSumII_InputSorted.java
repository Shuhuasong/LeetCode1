package LintCode.TwoPointer;

public class _608_TwoSumII_InputSorted {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums==null || nums.length==0) return new int[0];
        int n = nums.length;
        int l = 0, r = n-1;

        while(l < r){
            if(nums[l] + nums[r] < target){
                l++;
            }
            else if(nums[l] + nums[r] > target){
                r--;
            }
            else{
                return new int[]{l+1, r+1}; // need to return directly, otherwise, it will be TLE
            }
        }
        return null;
    }
}
