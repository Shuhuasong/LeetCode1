package String;

import java.util.*;

//10 ms (45%)
/*
public class LongestSubstring_02 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
       Set<Character> set = new HashSet<>();
       int len = s.length();
       int max = 0, left = 0, right = 0;
       while(left < len && right < len){
           if(!set.contains(s.charAt(right))){
               set.add(s.charAt(right));
               right++;
               max = Math.max(max, right-left);
           }else{
              set.remove(s.charAt(left));
              left++;

           }
       }
       return max;
    }
}

 */
//7ms (81.33%)
//Time Complexity: O(n)
//Space Complexity: O(1)
public class LongestSubstring_02 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null && s.length()==0) return 0;

        Set<Character> set = new HashSet<Character>();
        int left = 0, right = 0, max = 0;
        while(right<s.length()){
            if(set.add(s.charAt(right))){
                right++;
                max = Math.max(max, right - left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}