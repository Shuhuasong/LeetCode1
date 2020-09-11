package String.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _819_MostCommonWord {
    //Time: O(n+m) Spce: O(n+m)
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banWord = new HashSet<>();
        for(String s : banned){
            banWord.add(s);
        }
        String res = "";
        int maxFreq = 0;
        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        String[] strs = paragraph.split("\\s+");
        for(String s : strs){
            s = s.toLowerCase();
            map.put(s, map.getOrDefault(s,0)+1);
            if(map.get(s) > maxFreq && !banWord.contains(s)){
                res = s;
                maxFreq = map.get(s);
            }
        }

        return res;
    }
}
