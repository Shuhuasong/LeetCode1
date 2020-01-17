package String.Easy;

public class ReverseWordsInaString_151 {
/*
Given an input string, reverse the string word by word.

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
 */
//Time: O(n), space: O(n)
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

    //
    public String reverseWords(String s) {

    }
}
