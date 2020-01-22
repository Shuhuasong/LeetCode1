package String.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    //run time: 15 ms (5.55%) 59.1MB
    //Time complexity: O(n * (2^n)), Space: O(n)
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String>  l = new ArrayList<String>();
        helper(res, l, s, 0);
        return res;
    }

    public void helper(List<List<String>> res, List<String> l, String s, int k){
        if(k==s.length()){
            res.add(new ArrayList<String>(l));
            return;
        }

        for(int i=k+1; i<=s.length(); i++){
            if(isPalindrome(s.substring(k, i))){
                l.add(s.substring(k,i));
                helper(res, l, s, i);
                l.remove(l.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }


/*  //run time: 10 ms, (6.74% ) 60.6 MB
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, res);
        return res;
    }

    public void dfs(String s, int pos, List<String> list, List<List<String>> res){
        if(pos==s.length()) res.add(new ArrayList<String>(list));
        else{
            for(int i = pos; i<s.length(); i++){
                if(isPal(s, pos, i)){
                    list.add(s.substring(pos, i+1));
                    dfs(s, i+1, list, res);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public boolean isPal(String s, int low, int high){
        while(low<high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }


 */
}
