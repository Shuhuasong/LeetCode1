package LintCode.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class _56_TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<numbers.length; i++){
            if(!((HashMap) map).containsKey(target-numbers[i])){
                map.put(numbers[i], i);
            }else{
                res[0] = map.get(target-numbers[i]);
                res[1] = i;
            }
        }
        return res;
    }
}
