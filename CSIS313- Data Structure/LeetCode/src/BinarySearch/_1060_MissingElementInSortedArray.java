package BinarySearch;

public class _1060_MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if(missCnt(nums, n-1) > k){
            return nums[n-1] + k - missCnt(nums, n-1);
        }

        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int leftMiss = missCnt(nums, mid);
            if(leftMiss < k){
                left = mid + 1;
            }else
                right = mid-1;
        }
        return nums[left-1] + k - missCnt(nums, left-1);
    }

    public int missCnt(int[] nums, int idx){
        return nums[idx]-nums[0] - idx-0;
    }
}

/*
Algorithm

Implement missing(idx) function that returns how many numbers are missing until array element with index idx. Function returns nums[idx] - nums[0] - idx.

Find an index such that missing(idx - 1) < k <= missing(idx) by a binary search.

Return kth smallest nums[idx - 1] + k - missing(idx - 1).

*/
