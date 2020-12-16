package LintCode.TwoPointer;

public class _610_TwoSumDifferenceEqualTarget {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */

    //Time: O(nlogn) 
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if(nums==null || nums.length < 2) return new int[]{-1,-1};
        int[] res = new int[2];
        int n = nums.length;
        target = Math.abs(target);
        for(int i=0; i<nums.length; i++){
            int j = binarySearch(nums, i+1, n-1, nums[i]+target);
            if(j!=-1){
                return new int[]{nums[i], nums[j] };
            }
        }

        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int start, int end, int target){

        // int mid = left + (right-left)/2;
        while(start+1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
