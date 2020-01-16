package String.Easy;

public class ImplementstrStr_28 {

//time : O(n^2)
// space: O(1)
// 0 ms , (100%)
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for(int i=0; i<= haystack.length()-needle.length(); i++){
            if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}
