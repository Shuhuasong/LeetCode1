package Stack;

import java.util.Stack;

public class _978_BasicCalculator_LintCode {
    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        int currNum = 0, result = 0, sign = 1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10+(ch-'0');
            }else if(ch=='+'){
                result += currNum * sign;
                currNum = 0;
                sign = 1;
            }else if(ch=='-'){
                result += currNum * sign;
                currNum = 0;
                sign = -1;
            }else if(ch=='('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(ch==')'){
                result += currNum * sign;
                currNum = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(currNum!=0){
            result += currNum * sign;
        }
        return result;
    }
}

/*
我们需要三个变量和一个栈: number表示当前的操作数, sign表示当前的操作数应该被加还是被减, result表示结果.

初始number, result = 0, sign = 1, 开始遍历字符串:

碰到数字则追加到number尾端
碰到加号说明上一个数字已经完全被计算至number, 这时应该把number * sign加到result中, 然后把sign置为1 (因为当前碰到了加号)
碰到减号, 同上, 不同的在于最后要把sign置为-1
碰到左括号, 说明这时要优先出右边的表达式, 需要将result和sign压入栈中(注意, 此时的sign表示的是这个括号内的表达式应该被result加上还是减去), 然后初始化result和sign, 准备计算括号内的表达式
碰到右括号, 说明一个括号内的表达式被计算完了, 此时需要从栈中取出该括号之前的sign和result, 与当前的result相加运算 (注意, 是原来的result + sign * 当前result)
注意, 一个合法的表达式, 左括号之前一定不会是数字, 右括号之前一定是一个数字. 所以碰到右括号不要忘了先把number * sign加到当前result里.

以及, 循环结束后number可能还有数字, 需要加到result里. (比如"1+2"这样的表达式, 2并不会在循环内被加到结果中)
*/
