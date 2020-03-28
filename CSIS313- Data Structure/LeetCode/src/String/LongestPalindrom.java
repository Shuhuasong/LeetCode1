package String;

public class LongestPalindrom {
   /* public String longestPalindrome(String s) {
        if(s==null || s.length()<2) return s;
        int len = s.length();
        boolean[][] isPalindrom = new boolean[len][len];

        int left = 0;
        int right = 0;

        for(int j=1; j<len; j++){ //j = right
            for(int i=0; i<j; i++){ // i = left
                boolean isInnerPa = isPalindrom[i+1][j-1] || j-i<=2; //single char
                if(s.charAt(i)==s.charAt(j) && isInnerPa){
                    isPalindrom[i][j] = true;

                    if(j-i>right-left){
                        left = i;
                        right = j;
                    }
                }
            }
        }
       return  s.substring(left, right+1);
    }

    */
/*
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2) return s;
        int len = s.length();
        char[] sChar = s.toCharArray();
        int start = 0;
        int length = 1;
        boolean[][] isPalindrome = new boolean[len][len];
        for(int i=0; i<len; i++){  //length = 1
            isPalindrome[i][i] = true;
        }

        for(int i=0; i < len-1; i++){  //length = 2
            if(sChar[i]==sChar[i+1]){
                isPalindrome[i][i+1] = true;
                start = i;
                length = 2;
            }
        }
        for(int i=3; i<=len; i++) {
            for(int j=0; j+i-1 < len; j++){
                if(sChar[j]==sChar[j+i-1] && isPalindrome[j+1][j+i-2]==true){
                    isPalindrome[j][j+i-1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        return s.substring(start, start+length);
    }
    */


    //6ms, (87%)
    public String longestPalindrome(String s) {
        int len = 0;// the best lenght
        int start = 0;

        for(int i=0; i<s.length(); i++){
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i+1));
            if(cur>len){
                len = cur;
                start = i - (cur-1)/2;
            }
        }
        return s.substring(start, start+len);
    }

    private int getLen(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            --l;
            ++r;
        }
        return r-l-1;
    }
}


/*
class Solution {
public:
    string longestPalindrome(string s) {
        const int n = s.length();
        auto getLen = [&](int l, int r){
         while(l >= 0 && r<n && s[l]==s[r]){
             --l;
             ++r;
         }
        return r - l - 1;
    };

    int len = 0;
    int start = 0;
    for(int i=0; i<n; ++i){
        int cur = max(getLen(i,i),
                      getLen(i, i+1));
        if(cur > len){
            len = cur;
            start = i-(len-1)/2;
        }
    }
        return s.substr(start, len);
 }

};


 */

