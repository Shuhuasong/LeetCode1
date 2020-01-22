package String.Hard.SlicingWindow;

public class LongestSubstringLeastKRepeating_395 {

    //run time: 1ms (76%)
    public int longestSubstring(String s, int k) {
       if(s==null || s.length()==0) return 0;

       int[] hash = new int[26];
       for(char c : s.toCharArray()){
           hash[c-'a']++;
       }

       boolean fullString = true;
       for(int i=0; i<s.length(); i++){
           if(hash[s.charAt(i)] > 0 && hash[s.charAt(i)] < k){
               fullString = false;
           }
       }

       if(fullString) return s.length();
       int start = 0, end = 0, result = 0;
       while(end < s.length()){
           if(hash[s.charAt(end)] < k){
                result = Math.max(result, longestSubstring(s.substring(start, end),k));
               start = end + 1;
           }
           end++;
       }
       result = Math.max(result, longestSubstring(s.substring(start),k));

       return result;
    }
}
