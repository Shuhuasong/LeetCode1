package String.Easy;

/*
Given two Strings S and T, determine if they are both one edit distance apart
Example:
S = "abc"
T = "ab" return true

S = "abcd"
T = :abdf"
 */

/*
 a. if abs(S.length()-T.length()) > 1  return false;
 b. if  abs(S.length()-T.length()) = 1  ==> isOneRemoveDistance(s,t) or isOneRemoveDistance(t,s);
 c. if  abs(S.length()-T.length()) = 0  ==> isOneChangeDistance(s, t);
     example:
     S = "a b c d f"
          f
     T = "a b e d t"
          s
 */

//time: O(n)
//Space: O(1)

public class OneEditDistance_161 {
     public boolean isOneEditDistance(String s, String t){
         if(s==null && t==null) return true;
         if(s==null || t==null) return false;

         int m = s.length();
         int n = t.length();

         if(m == n) { return isOneChange(s, t); }
         else if(n-m==1) { return isOneRemove(s, t);}
         else if(m-n==1) { return isOneRemove(t, s);}
         return false; // n-m>2
     }

     public boolean isOneChange(String s, String t){
         int n = s.length();
         boolean flag = false;
         for(int i=0; i<n; i++){
             if(s.charAt(i) != t.charAt(i)){
                 if(flag){
                     return false; //second time found there are two charater differently;
                 }else{
                     return true;
                 }
             }
         }
         return flag;
     }

     public boolean isOneRemove(String s, String t){
         int n = t.length();
         boolean flag = false;
         int fast = 0;
         for(int slow=0; slow<n;slow++){
             if(s.charAt(fast)!=t.charAt(slow)){
                 if(flag){
                     return false;
                 }
                 flag = true;
                 slow--;
             }
             fast++;
         }
         return true;
     }

}
