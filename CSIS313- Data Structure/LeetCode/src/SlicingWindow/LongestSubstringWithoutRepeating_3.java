package SlicingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {

            if (set.add(s.charAt(right))) { //add() returns True if the element is not present in the set and is new
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }

        }
        return max;
    }

    /*  public int lengthOfLongestSubstring(String s) {
       if(s==null || s.length()==0) return 0;
       Map<Character, Integer> map = new HashMap<>();

       int left = 0;
       int right = 0;
       int maxLen = 0;
       int count = 0;
       while(right < s.length()){
           char c = s.charAt(right);
           map.put(c, map.getOrDefault(c, 0)+1);

           if(map.get(c)>1) count++;
           right++;

           while(count > 0){
               char tmpC = s.charAt(left);
               if(map.get(tmpC)>1) count--;

               map.put(tmpC, map.get(tmpC)-1);
               left++;

           }
           maxLen = Math.max(maxLen, right - left);
       }
       return maxLen;
   }
    */
}
