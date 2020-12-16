package LintCode.String;

import java.util.ArrayList;
import java.util.List;

public class _194_FindWords {
    /**
     * @param str: the string
     * @param dict: the dictionary
     * @return: return words which  are subsequences of the string
     */
    public List<String> findWords(String str, List<String> dict) {
        // Write your code here.
        List<String> res =  new ArrayList<>();
        for(String item : dict){
            int i=0, j=0;
            while(i<item.length() && j<str.length()){
                if(item.charAt(i) != str.charAt(j)){
                    j++;
                }else{
                    i++;
                    j++;
                }
            }
            if(i==item.length()) res.add(item);
        }
        return res;
    }
}
