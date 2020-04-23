package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(i);
        }
        int j=0;
        for(int num : nums1){
            res[j++] = map.get(num);
        }
        return res;
    }
}
