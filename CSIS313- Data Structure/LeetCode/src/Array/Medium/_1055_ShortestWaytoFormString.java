package Array.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _1055_ShortestWaytoFormString {
    //solution#1: -HashMap
    //Time: O(n) Space: O(n)
  /*  public int shortestWay(String source, String target) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            TreeSet<Integer> idxSet = map.getOrDefault(c, new TreeSet<>());
            idxSet.add(i);
            map.put(c, idxSet);
        }
        int lastIdx = -1;
        int  res = 0;
        int n = target.length();
        for(int j=0; j<n; ){
            char ch = target.charAt(j);
            if(!map.containsKey(ch)) return -1;
            TreeSet<Integer> curSet = map.get(ch);
            Integer highIdx = curSet.higher(lastIdx);
            if(highIdx==null){
                res++;
                lastIdx = -1;
            }else{
                lastIdx = highIdx;
                j++;
            }
        }
        return res+1;
    }

   */

  //solution#2 : two pointer
  //Time: O(n) Space: O(n)
  public int shortestWay(String source, String target) {
      int p2 = 0;
      int res = 0;
      boolean isSub = false;
      while(p2 < target.length()){
          isSub = false;
          for(int i=0; i<source.length() && p2<target.length(); i++){
              if(source.charAt(i)==target.charAt(p2)){
                  p2++;
                  isSub = true;
              }
          }
          if(!isSub) return -1;
          res++;
      }
      return res;
  }
}
