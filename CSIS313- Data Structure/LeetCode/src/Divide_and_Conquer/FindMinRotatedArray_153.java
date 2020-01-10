package Divide_and_Conquer;

public class FindMinRotatedArray_153 {


    //run time: 4ms (>76.16%)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
  /*
    public int findMin(int[] nums) {
     for(int i=0; i<nums.length; i++){
         if(nums[i]<nums[i+1])
             return nums[i];
     }
     return -1;
    }

   */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left<right){
            int mid = left + (right-1)/2;
            if((nums[mid]>nums[left])){ //left side is sorted
                left = mid;
            }else{
                right = mid;
            }
        }
        return Math.min(nums[0], Math.min(nums[left], nums[right]));
    }
}


/*
//C++ Time complexity: O(logn)
public:
    int findMin(vector<int>& nums) {
        finMin(nums, 0, nums.size()-1);
    }

    int findMin(const vector<int>& num, int l, int r)
   {
       // One or two elements, solve it directly
       if (l+1 >= r) return
           min(num[l], num[r]);

       // Sorted
       if (num[l] < num[r])
           return num[l];

       int m = l + (r-l)/2;

       // Recursively find the solution
       return min(findMin(num, l, m - 1),
                  findMin(num, m, r));
   }
 */