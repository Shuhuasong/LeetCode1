package Stack;

import java.util.Stack;

public class _980_BasicCalculatorII_LIntCode {
    public int calculate(String s) {
        // Write your code here
        if(s==null || s.length()==0){
            return 0;
        }
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c-'0');
            }
            if(!Character.isDigit(c) && c != ' ' || i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop() * num);
                }else if(sign=='/'){
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
/*
 1) inicialize viriable num = 0, sign = '+', and iterate the whole string
 2) push the first number
 3) if the sign = +, we store +num
 4) if the sign = -, we store -num
 5) if the sign = *, pop() a number, and let currNum * stack.pop(), push the result again into stack;
 6) if the sign = '/', pop() a number, and let currNum / stack.pop(), push the result again into stack;
*/