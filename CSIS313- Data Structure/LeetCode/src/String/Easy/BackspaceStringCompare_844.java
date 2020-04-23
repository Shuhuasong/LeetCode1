package String.Easy;

import java.util.Stack;

public class BackspaceStringCompare_844 {
     /* public boolean backspaceCompare(String S, String T) {
      int i=S.length()-1;
      int j=T.length()-1;
      int sSkip = 0;
      int tSkip = 0;
      while(i>=0 || j>=0){
          while(i>=0){
              if(S.charAt(i)=='#'){
                  sSkip++;
                  i--;
              }else if(sSkip > 0){
                  sSkip--;
                  i--;
              }else{
                  break;
              }
          }

           while(j>=0){
              if(T.charAt(j)=='#'){
                  tSkip++;
                  j--;
              }else if(tSkip > 0){
                  tSkip--;
                  j--;
              }else{
                  break;
              }
          }

          if(i>=0 && j>=0 && S.charAt(i) != T.charAt(j)){
              return false;
          }
          if((i>=0) != (j>=0)){ //the lenghth are different
              return false;
          }

          i--;
          j--;
       }
        return true;
    }
    */

   /* public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
    
    */


    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c !='#'){
                sStack.push(c);
            }else if(!sStack.isEmpty()){
                sStack.pop();
            }
        }

        Stack<Character> tStack = new Stack<>();
        for(char c : T.toCharArray()){
            if(c !='#'){
                tStack.push(c);
            }else if(!tStack.isEmpty()){
                tStack.pop();
            }
        }

        while(!sStack.isEmpty()){
            char ch = sStack.pop();
            if(tStack.isEmpty() || ch != tStack.pop()){
                return false;
            }
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }
}
