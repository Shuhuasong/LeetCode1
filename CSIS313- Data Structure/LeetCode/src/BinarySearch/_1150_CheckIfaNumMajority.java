package BinarySearch;

public class _1150_CheckIfaNumMajority {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int firstIdx = findFirstIndex(nums, target);
        int lastIdx = firstIdx + n/2;
        if(lastIdx < n && nums[lastIdx]==target){
            return true;
        }
        return false;
    }

    public int findFirstIndex(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < target){
                low = mid+1;
            }else if(nums[mid] >= target){
                high = mid-1;
            }
        }
        return low;
    }
}
