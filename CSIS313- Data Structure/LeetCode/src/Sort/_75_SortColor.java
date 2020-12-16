package Sort;

public class _75_SortColor {
   /*

   public void sortColors(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();

       for(int a : nums){
           map.put(a, map.getOrDefault(a,0)+1);
       }
       int k = 0;
       int len1 = map.get(0), len2 = map.get(1), len3 = map.get(2);
       for(int i=0; i<len1; i++){
           nums[k++] = 0;
       }
       for(int i=0; i<len2; i++){
           nums[k++] = 1;
       }
       for(int i=0; i<len3; i++){
           nums[k++] = 2;
       }
    */




    public void sortColors(int[] nums) {
        // write your code here
        int n = nums.length;
        int l = 0,  mid = 0;
        int r = n-1;
        while(mid <= r){
            if(nums[mid]==0){
                swap(nums, l, mid);
                l++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums, mid, r);
                r--;
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
