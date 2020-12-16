package InterviewChallege.VMware2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
A subsequence of a string is obatained by deleting zero or more characters from the
string while maintaining order. Given a string generate an array of all subsequences
sorted alphabetically ascending, omitting the empty string
Example:
 input:   s = "xyz"
 Not including the empty string the sorted subsequences are
 output:  ['x', 'xy', 'xyz', 'xz', 'y', 'yz', 'z']
 constrains: 1 < length of s < 16
 s is a string of distinct lowercase


 */
public class _BuildtheSubsequences {
    List<String> res = new ArrayList<>();
    public List<String> buildSubsequences(String s){
        int idx = -1, n = s.length();
        String curStr = "";
        getSubseq(s, idx, curStr, n);
        Collections.sort(res);
        return res;
    }

    public void getSubseq(String s, int idx, String curStr, int n){
        if(idx==n) return;
        if(curStr != null && curStr.trim().isEmpty()){
            res.add(curStr);
        }
        for(int i=idx; i<n; i++){
            curStr += s.charAt(i);
            getSubseq(s, i, curStr, n);
            //backtracking
            curStr = curStr.substring(0,curStr.length()-1);
        }
    }
}
