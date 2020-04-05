package Array.Medium;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        if(nums.length< 2) return true;
        int reach = 0;
        for(int i=0; i<nums.length && i<=reach; i++){
            reach = Math.max(nums[i]+i, reach);
            if(reach >= nums.length-1) return true;
        }
        return false;
    }

    /*
     //Time: O(n) Space: O(1)
    public boolean canJump(int[] nums) {
       if(nums.length < 2) return true;
       int max = 0;//The max jump
       for(int i=0; i<nums.length; i++){
           if(i > max) return false; //the current index is greater than the max(that I can jump)
           int cur = i+nums[i];
           max = Math.max(cur, max);
       }
        return max >= nums.length-1;
     }  
     */
}
