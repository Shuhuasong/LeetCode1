package String.Easy;

import java.util.HashMap;

public class IsomorphicString_205 {

    //Time: O(n)
    //Space: O(1) // the maximum of space is 26 hashmap
    // run: 5ms (50%)
  /*  public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null) return true;
        HashMap<Character, Character> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a)==b)
                    continue;
                else
                    return false;
            }else{
                if(!map.containsValue(b)){
                    map.put(a, b);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

   */
  // run time: 5ms (80%)

    public boolean isIsomorphic(String s, String t) {
        for(int i=0; i<s.length(); i++){
            if(s.indexOf(s.charAt(i))!= t.indexOf(t.charAt(i))) return false;
        }
        return true;
    }

}
