package String.Easy;
/*
canWin("+++++") = !canWin("--+++") || !canWin("+--++") !canWin("++--+") !canWin("+++--")

 */

//Time: O(n^n)
public class FlipGame_294 {
    public boolean canWin(String s){
        if(s==null || s.length()<2) return false;

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                String nextState = s.substring(0, i) +"--"+ s.substring(i+2);
                //                                    i i+1
                if(!canWin(nextState)) return true;
            }
        }
        return false;
    }
}
