package Array.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int j=0;
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])>0){
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for(int num : list){
            res[j++] = num;
        }
        return res;
    }
}
