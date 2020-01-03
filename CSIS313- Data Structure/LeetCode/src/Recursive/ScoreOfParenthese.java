package Recursive;

public class ScoreOfParenthese {
   /* public int scoreOfParentheses(String S) {
        int ans = 0;
        int d = -1;
        for(int i=0; i<S.length(); i++){
            d += (S[i]=='(') ? 1: -1;
            if(S.charAt(i)=='(' && S.charAt(i+1)==')'){
                ans += (int) Math.pow(2,d);
            }
        }
        return ans;
    }

    */

    public int scoreOfParentheses(String S) {
        return score(S, 0, S.length()-1);
    }

    public int score(String S, int l, int r){
        if(r-l == 1) return 1;
        int b = 0;
        for(int i=l; i<r; ++i){
            if(S.charAt(i)=='(') ++b;
            if(S.charAt(i)==')') --b;
            if(b==0)
                return score(S, l, i) + score(S, i + 1, r);

        }
        return 2 * score(S, l+1, r-1 );
    }

}
