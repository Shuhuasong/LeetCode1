package Array.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements_658 {
    //Time: O(log n+k)
 /*   public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>();
        int left = 0; //the left for window
        int right = arr.length-k;
        while(left < right){
            int mid = left+(right-left)/2;
            if(x-arr[mid] > arr[mid+k]-x){
                left = mid + 1;
              }
             else{
                 right = mid; //the maximum left side for size k is at mid
              }
            }

        for(int i=left; i<left+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
    */
    //Time: O(nlogn)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            list.add(num);
        }
        Collections.sort(list, (a, b) -> Math.abs(a-x)-Math.abs(b-x));
        List<Integer> sub = list.subList(0, k);
        Collections.sort(sub);

        return sub;
    }

}


//  Collections.sort(): It is used to sort the elements present in the specified list of Collection in ascending order.