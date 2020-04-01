package String.Easy;

public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int l1 = chs.length;
        int l2 = cht.length;
        int i=0, j=0;
        while(i<l1 && j<l2){
            if(chs[i]==cht[j]){
                i++;
            }
            j++;
        }
        if(i==l1) return true;
        else return false;
    }
}
