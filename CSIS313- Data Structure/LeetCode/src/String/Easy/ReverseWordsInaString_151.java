package String.Easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ReverseWordsInaString_151 {
/*
Given an input string, reverse the string word by word.

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
 */
//Time: O(n), space: O(n)
//run: 5ms (63%)
    public String reverseWords(String s) {
        if(s==null && s.length()==0) return "";

        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split("\\s+"); //split by space
        int n = strs.length;
        for(int j=n-1; j>=0; j--){
            sb.append(strs[j] + " ");
        }
        return sb.toString().trim();
    }

    //Time: O(n), space: O(n)
    //Run: 5ms (63%)
 /*   public String reverseWords(String s) {
        if(s==null && s.length()==0) return s;
        char[] ch = s.trim().split("\\s+");
       Collections.reverse(Arrays.asList(ch));
       return String.join(" ", ch);
    }




    //run time: 4ms (68%)
    public String reverseWords(String s) {
        if(s==null && s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split("\\s+");
        int n = strs.length;
        for(int i=0; i<n/2; i++){
            String temp = strs[i];
            strs[i]=strs[n-i-1];
            strs[n-i-1] = temp;
        }
        for(int j=0; j<n; j++){
            sb.append(strs[j]+" ");
        }
        return sb.toString().trim();

    }

  */
}
