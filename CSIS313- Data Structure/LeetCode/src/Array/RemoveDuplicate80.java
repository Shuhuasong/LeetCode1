package Array;

//Time Complexity: O(n)
//Space Complexity: O(1)
//start from third one, to check if the third element is the same with the 2nd previous element, if it is not the same, then
// count this number, and move the j forwrard;
public class RemoveDuplicate80 {

    public int removeDuplicates(int[] nums) {
        int j= 2;
        for(int i=2; i<nums.length; i++){
            if(nums[j-2] != nums[i]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
