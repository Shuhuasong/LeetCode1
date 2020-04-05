package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote==null || ransomNote.length()==0) return true;
        if(magazine==null || magazine.length()==0) return false;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c : ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c)==1) count++;
        }

        for(int i=0; i<magazine.length(); i++){
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i),0)-1);
            if(map.get(magazine.charAt(i))==0){
                count--;
                if(count==0) return true;
            }

        }
        return count==0;
    }

 /*   public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote==null || ransomNote.length()==0) return true;
        if(magazine==null || magazine.length()==0) return false;
        int[] r = new int[26];
        int[] m = new int[26];
        for(int i=0; i<ransomNote.length(); i++){
            r[ransomNote.charAt(i)-'a']++;
        }
        for(int j=0; j<magazine.length(); j++){
            m[magazine.charAt(j)-'a']++;
        }
        for(int k=0; k<26; k++){
            if(r[k]>m[k])
                return false;

        }
        return true;
    }
    */

    //Time: O(m+n) Space: O(n)
  /*  public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote==null || ransomNote.length()==0) return true;
        if(magazine==null || magazine.length()==0) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : ransomNote.toCharArray()){
            if( !map.containsKey(c) || map.get(c)<=0){//there is character in Magazine, or ransomNote use too many character so that it decrease to 0 eventually
                return false;
            }
            map.put(c, map.getOrDefault(c,0)-1);
        }
        return true;
    }

   */
}

/*
Two cases we need to think about:
(1) the character in the ransomNote but not in the magazine;("a", "b")
(1) the character in the ransomNote is not enough in hte the magazine;("aa", "ab")


*/
