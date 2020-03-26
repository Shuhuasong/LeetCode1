package Array;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null && nums2 == null) return;
        int i = 0;
        while(i < n){
            nums1[m++] = nums2[i++];
        }
        Arrays.sort(nums1);
    }
}
