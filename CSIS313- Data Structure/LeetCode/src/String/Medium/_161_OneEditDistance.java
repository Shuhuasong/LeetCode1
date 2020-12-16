package String.Medium;

public class _161_OneEditDistance {
    //Time: O(n) Space: O(1)
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        //Ensure that s is short than t
        if(m > n){
            return isOneEditDistance(t, s); //switch s, t
        }
        //if the length of difference greater than one, it means it is not one edit away
        if(m - n > 1) return false;
        for(int i=0; i<m; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(m==n){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{
                    //s is shorter than t
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        //If there is no diff, the strings are one edit away only if t has one more character
        return m+1 == n;
    }
}
