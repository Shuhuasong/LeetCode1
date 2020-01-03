package Stack;

import java.util.Stack;

public class MiniRemoveParent1249 {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] S = s.toCharArray();
        for(int i=0; i<S.length; i++){
            if(S[i]=='(') stack.push(i);
            else if(S[i]==')'){
                if(stack.isEmpty()){
                    S[i] ='*';
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            S[stack.pop()] = '*';
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length; i++){
            if(S[i] != '*'){
                sb.append(S[i]);
            }
        }
        return sb.toString();
    }

   /* public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0;
        int close = 0;
        for(char c : s.toCharArray()){
            if(c=='(') {
                open += 1;
                stack.push(c);
            }
            else if(c==')'){
               if(close < open){
                   close += 1;
                   stack.push(c);
               }
            }else{
                stack.push(c);
            }
        }
       open = 0; close = 0;
       String res="";
       while(!stack.isEmpty()){
          char c = stack.pop();
          if(c=='('){
              if(open<close){
                  open += 1;
                  res = c + res;
              }

          }else if(c==')'){
              close += 1;
              res = c + res;
          }else{
              res = c + res;
          }
       }
       return res;
    }

    */
}
