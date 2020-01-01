package Stack;

import java.util.Stack;

public class MinimumParentheses921 {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c==')' && !stack.isEmpty() && stack.peek()==')') stack.pop();
        }
        return stack.size();
    }

    /*
   //10 ms
    public int minAddToMakeValid(String s) {
       if(s.contains("()")) {
           s.replace("()", "");
       }
       return s.length();
    }

     */

    //0 ms
   /* public int minAddToMakeValid(String s) {
       int closeNeed = 0;
        int totalNeed = 0;
        int i = 0;
        int n = s.length();
        while(i<n){
            if(s.charAt(i)=='('){
                closeNeed++;
            }else{
                if(closeNeed>0){
                    closeNeed--;
                }else{
                    totalNeed++;
                }
            }
            i++;
        }
        totalNeed += closeNeed;
        return totalNeed;
    }

    */

    /* // 2ms
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(!stack.isEmpty()){
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }
     */
}



