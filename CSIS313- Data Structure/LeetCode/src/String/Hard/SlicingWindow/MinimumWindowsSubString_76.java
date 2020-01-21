package String.Hard.SlicingWindow;

/*Example:
  S : HEVGOUARWQBAACPPKL
            L   L  R
  T : ABC

 */

//run time: 11ms (70%)
/*public class MinimumWindowsSubString_76 {
    public String minWindow(String s, String t){
       if(s==null || t==null || s.length()==0 || t.length()==0) return "";
       int matchCount = 0;
       String res = "";
       int[] tArr = new int[256];
       for(char c : t.toCharArray()){
           tArr[c]++;
       }
       int[] sArr = new int[256];
       int left = findNextStrIdx(0, s, tArr);
       if(left == s.length()) return "";
       int right = left;
       while(right<s.length()){
           int rightChar = s.charAt(right);
           if(sArr[rightChar] < tArr[rightChar]){
               matchCount++;
           }
           sArr[rightChar]++;
           while(left < s.length() && matchCount == t.length()){
               if(res.isEmpty() || res.length() > right-left+1){
                   res = s.substring(left, right+1);
               }
               int leftChar = s.charAt(left);
               if(sArr[leftChar] <= tArr[leftChar]){
                   matchCount--;
               }
               sArr[leftChar]--;
               left = findNextStrIdx(left+1, s, tArr);
           }
           right = findNextStrIdx(right+1, s, tArr);
       }
       return res;
    }

    public int findNextStrIdx(int start, String s, int[] tArr){
        while(start < s.length()){
            char c = s.charAt(start);
            if(tArr[c] != 0) return start;
            start++;
        }
        return start;
    }
}
 */


public class MinimumWindowsSubString_76 {
    public String minWindow(String s, String t){
       if(s==null || t==null || s.length()==0 || t.length()==0|| s.length() < t.length()){
           return "";
       }

    }
}

