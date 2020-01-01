package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class GenerateParenthese22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return new LinkedList<>();
        else if(n==1){
            res.add("()");
        }else{
            StringBuilder cur = new StringBuilder();
            addParent(res, n, 0, cur);
        }
        return res;
    }

    private void addParent( List<String> res, int left, int right, StringBuilder cur) {
        if(left==0 && right==0) {
            res.add(cur.toString());
        }
        if(right>0){
            cur.append(")");
            addParent(res, left, right-1, cur);
            cur.setLength(cur.length()-1);
        }
        if(left>0){
            cur.append("(");
            addParent(res, left-1, right+1, cur);
            cur.setLength(cur.length()-1);
        }
    }


    /* //recursive
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if(n==0) return new LinkedList<>();
        else if(n==1){
            res.add("()");
        }else{
            addParent("", res, n, 0, 0);
        }
        return res;
    }

    private void addParent(String cur, List<String> res, int n, int left, int right) {
        if(right==n){
            res.add(cur);
        }
        if(left<n){
            addParent(cur + "(", res, n, left+1,right);
        }
        if(right<left){
            addParent(cur + ")", res, n, left, right+1);
        }
    }

     */

}
