package Array;

public class RemoveDuplicate_26 {
    //O(n) Space: O(1)
    //run: 0ms (100%)
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int nonDupIdx = 1;
        int lastNum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]==lastNum) continue;
            else{
                nums[nonDupIdx++] = nums[i];
                lastNum = nums[i];
            }
        }
        return nonDupIdx;
    }


}



