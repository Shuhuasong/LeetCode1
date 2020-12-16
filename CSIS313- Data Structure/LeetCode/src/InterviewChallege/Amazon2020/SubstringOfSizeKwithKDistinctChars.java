package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
/*
Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

Example 1:

Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]
Example 2:

Input: s = "abacab", k = 3
Output: ["bac", "cab"]
Example 3:

Input: s = "awaglknagawunagwkwagl", k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
Explanation:
Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
"wagl" is repeated twice, but is included in the output once.
 */

public class SubstringOfSizeKwithKDistinctChars {

    public SubstringOfSizeKwithKDistinctChars(){}

    public static List<String> getSubstring(String str,int k){
      int n = str.length();
      Set<String> result =  new HashSet<>();
      if(n < k) return new ArrayList<>(result);
      Set<Character> set = new HashSet<>();
      int i = 0;
      for(int j=0; j<n; j++){
          char ch = str.charAt(j);
         // System.out.println("ch: " + ch + " " + j);
          if(set.add(ch)){
              if(set.size()==k){
                  String cur = str.substring(i, j+1);
                  result.add(cur);
                  set.remove(str.charAt(i));
                  //System.out.println("Cur: " + cur);
              }else
                  continue;
          }
          else{
              set.remove(ch);
             // System.out.println("i: " + i);
              set.add(ch);
          }
          i++;
      }
      List<String> answer = new ArrayList<>();
      answer = new ArrayList<>(result);
      Collections.sort(answer);
      return answer;
    }


    public static void main(String args[]) throws IOException {
        SubstringOfSizeKwithKDistinctChars sub = new SubstringOfSizeKwithKDistinctChars();
        String str = "awaglknagawunagwkwagl";
        int k = 4;
        List<String> result = getSubstring(str, k);
        for(String s : result){
            System.out.print(s + " ");
        }
    }
}




//https://leetcode.com/discuss/interview-question/370112