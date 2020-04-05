package Array.Medium;

public class FindTheDuplicateNumber_287 {

    //Time: O(n) Space: O(1)
   /*public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length];
        for(int num : nums){
            count[num] = count[num] + 1;
            if(count[num] > 1) return num;
        }
        return 0;
    }
    */
    //Time: O(n)  Space: O(1)
   /* public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
       do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int ptr1 = nums[0];
        int ptr2 = slow;
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
    */
}
