package String.Medium;

/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:
Eg: given: ["abc","bcd","acef", "xyz","az","ba","a","z"]
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//
public class GroupShiftedString_249 {
    public List<List<String>> groupStrings(String[] strings){
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strings){
            char[] arr = s.toCharArray();
            if(arr.length>0){
                int diff = arr[0] - 'a';
                for(int i=0; i<arr.length; i++){
                    if(arr[i]-diff < 'a'){
                        arr[i] = (char)(arr[i]-diff+26);
                    }else{
                        arr[i] = (char)(arr[i]-diff);
                    }
                }
            }
            String keyS = new String(arr);
            if(map.containsKey(keyS)){
                 map.get(keyS).add(s);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(keyS);
            }
        }
        res.addAll(map.values());
        return res;
    }

}
