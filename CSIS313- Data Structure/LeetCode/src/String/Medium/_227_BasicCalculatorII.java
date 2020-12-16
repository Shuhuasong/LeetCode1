package String.Medium;

import java.util.Stack;

public class _227_BasicCalculatorII {
    //Time: O(n) Space: O(n)
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(!Character.isDigit(c) && s.charAt(i) != ' ' || i==n-1){
                if(sign=='+') stack.push(num);
                if(sign=='-') stack.push(-num);
                if(sign=='*') stack.push(stack.pop() * num);
                if(sign=='/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }

        }
        int res = 0;
        for(int val : stack){
            res += val;
        }
        return res;
    }
}
