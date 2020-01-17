package String.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class GroupAnagrams_49 {
    //run time: 7ms (99.28%)
    //time: O(n*n*log n)  space: O(n)
    public List<List<String>> groupAnagrams(String[] strs)  {
       List<List<String>> res = new ArrayList<>();
       if(strs==null && strs.length==0) return res;
       HashMap<String, Integer> map = new HashMap<>();
       for(String str : strs) {
           char[] ch = str.toCharArray();
           Arrays.sort(ch); // O(nlog n)
           String s = new String(ch); //s = "aet"
           if(map.containsKey(s)){
               List<String> list = res.get(map.get(s));
               list.add(str);
           }else{
               List<String> list = new ArrayList<>();
               list.add(str);
               map.put(s, res.size());// map.put("aet", 0), map.put("ant", 1), map.put("abt", 2), the number means the index of string list in the res of list
               res.add(list);
           }
       }
       return res;
    }

   // run time: 40 ms (8.14.28%)
    //time : O(m * n) space: O(n)
    //  "eat" ==> s = "1a1e1t"
 /*   public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            for(char ch: str.toCharArray()){ //O(1)
                count[ch-'a']++;
            }
            String s = "";
            for(int i=0; i<count.length; i++){
                if(count[i] != 0){
                    s += String.valueOf(count[i])+ String.valueOf((char)(i+'a'));
                }
            }
            if(map.containsKey(s)){
                List<String> list = map.get(s);
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }

  */

}
