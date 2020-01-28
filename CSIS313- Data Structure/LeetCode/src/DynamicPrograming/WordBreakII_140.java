package DynamicPrograming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII_140 {
    //run time: 11ms  (30%)
    //Time Complexity: O(n^2) Space: O(n)
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        HashMap<String, List<String>> used = new HashMap<String, List<String>>();
        for(String str : wordDict){
            set.add(str);
        }
        res = helper(s, set, used);
        return res;
    }

    public List<String> helper(String s, HashSet<String> set, HashMap<String, List<String>> used){
        if(used.containsKey(s)) return used.get(s);

        if(s.length()==0) return null;
        List<String> res = new LinkedList<String>();
        for(int i=1; i<= s.length(); i++){
            String sub = s.substring(0, i);
            List<String> partRes = null;
            if(set.contains(sub)){
                partRes = helper(s.substring(i),set, used);
                if(partRes == null) res.add(sub);
                else{
                    for(String str : partRes){
                        res.add(sub + " " + str);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}
