package Divide_and_Conquer;

public class FindMInRotatedArrayII_154 {
}
/*
public:
    int findMin(vector<int> &nums) {
        return findMin(nums, 0, nums.size()-1);
    }

    int findMin(const vector<int>& nums, int l, int r)
    {
        // One or two elements, solve it directly
        if (l+1 >= r) return
            min(nums[l], nums[r]);

        // Sorted
        if (nums[l] < nums[r])
            return nums[l];

        int m = l + (r-l)/2;

        // Recursively find the solution
        return min(findMin(nums, l, m - 1),
                   findMin(nums, m, r));
    }
 */