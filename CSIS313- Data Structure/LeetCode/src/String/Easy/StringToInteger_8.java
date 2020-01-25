package String.Easy;

public class StringToInteger_8 {

    //6ms (13%) 42.9MB

    //Time: O(n)
    //Space: O(1)
    public int myAtoi(String str) {
        if(str == null || str.length()==0) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1;
        int res = 0;
        int start = 0;
        if(firstChar=='+'){
            sign = 1;
            start++;
        }
        else if(firstChar=='-'){
            sign = -1;
            start++;
        }
        for(int i = start; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return (int) sign * res ;
            }
            res = res * 10 + str.charAt(i)-'0';
        }
        if(sign == 1 && res > Integer.MAX_VALUE)  return   Integer.MAX_VALUE;
        if(sign == -1  && res > Integer.MAX_VALUE) return  Integer.MIN_VALUE;
        return (int) res * sign;
   }
}
