package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfaPhoneNumber_17 {
    //Time:
    //run: 4ms (30%)
  /*  public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)  return res;

        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        combination(res, digits, 0, "", mapping);
        return res;
    }

    private void combination(List<String> res, String digits, int index, String curString, String[] mapping){
        if(index==digits.length()){
            res.add(curString);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for(int i=0; i<letters.length(); i++){
            combination(res, digits, index+1, curString+letters.charAt(i), mapping);
        }
    }

   */

    //Time: O(M*N) Space: O(N)
    //run: 0ms (100%)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)  return res;
        StringBuilder sb = new StringBuilder();
        Map<Character, char[]> map = new HashMap<>(); //(1)why we use  char[]
        map.put('2',new char[] {'a', 'b', 'c'});
        map.put('3',new char[] {'d', 'e', 'f'});
        map.put('4',new char[] {'g', 'h', 'i'});
        map.put('5',new char[] {'j', 'k', 'l'});
        map.put('6',new char[] {'m', 'n', 'o'});
        map.put('7',new char[] {'p', 'q', 'r','s'});
        map.put('8',new char[] {'t', 'u', 'v'});
        map.put('9',new char[] {'w', 'x', 'y','z'});

        dfs(digits, res, sb, 0, map);
        return res;
    }

    private void dfs(String digits, List<String> res, StringBuilder sb, int index, Map<Character, char[]> map){
        if(sb.length()==digits.length()){
            res.add(sb.toString());//(2)why we don't use deep copy? (new ArrayList<String>(curList))
            return;
        }

        char ch = digits.charAt(index);
        char[] value = map.get(ch);
        for(int i=0; i<value.length; i++){
            sb.append(value[i]);
            dfs(digits, res, sb, index+1, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}

//digits: "23"                 []
//2         [a]                [b]                 [c]
//3.   [ad][ae][af]      [bd][be][bf]         [cd][ce][cf]

//(1) char[] is reference type, but char is a primitive type, so we need to use Character(the Wrapper Class)
//(2) sb.toString will create a new object automatically, and copy the value we need into this object, so we don't need it

