package Stack.Medium;

import java.util.Stack;

public class ValidParenthesisString_678 {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                open.push(i);
            }else if(s.charAt(i)=='*'){
                star.push(i);
            }else{
                if(!open.isEmpty()){
                    open.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }

        while(!open.isEmpty()){
            if(star.isEmpty()){
                return false;
            }else if(open.peek() < star.peek()) { // (*
                open.pop();
                star.pop();
            }else{
                return false; // case: open.top() > star.top()  *(
            }
        }
        return true;
    }
}


/*
1)  (*) T   (*)) T  )*() F   *()) T  **()) T
2)  The position of start is important: *( F  *) T  (*

3)      0  1  2  3  4  5    True
        (  *  (  *  *  )

 Open   0  2
 Star   1  3  4
two * left are empty string

        0  1  2  3  4  5   False *(
        *  *  *  (  (  )
 Open   3  4
 Star   0  1  2

*/

