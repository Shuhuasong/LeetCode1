package Array;

public class SearchInsertPosition_35 {
    //Time: O(n) 
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
