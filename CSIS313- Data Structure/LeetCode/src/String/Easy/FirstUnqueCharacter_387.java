package String.Easy;

import java.util.HashMap;

public class FirstUnqueCharacter_387 {
    //run: 10ms (70%)
  /*  public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCounts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
   */

  //run: 8ms (86%), 46.2MB
    //
  /*  public int firstUniqChar(String s) {
        int[] counts = new int[26];
        for(char c : s.toCharArray()){
            counts[c-'a']++;
        }

        for(int i=0; i<s.length(); i++){
            if(counts[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

   */
//38 ms (47.73%) 46.6MB
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : chars){
           map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }
}


