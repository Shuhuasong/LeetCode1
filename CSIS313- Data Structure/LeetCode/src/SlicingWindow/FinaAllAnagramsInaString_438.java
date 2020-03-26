package SlicingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FinaAllAnagramsInaString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int count = map.size();
        int begin = 0;
        int end = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)==0)  count--;
            }

            end++;

            while(count==0){

                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc)+1);
                    if(map.get(tempc) > 0) count++;
                }

                if((end-begin) == p.length()) res.add(begin);
                begin++;
            }
        }
        return res;
    }
}
