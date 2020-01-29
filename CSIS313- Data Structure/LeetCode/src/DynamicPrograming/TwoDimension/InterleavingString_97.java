package DynamicPrograming.TwoDimension;

public class InterleavingString_97 {

    /*status: dp[length1][length2]  length1: a small piece of length in String 1 or 2
    init : [0][0] = true;
    function:
    result:

     */
    public boolean isInterleave(String s1, String s2, String s3) {
      if(s1==null || s2==null || s3==null) return false;
      if(s1.length() + s2.length() != s3.length()) return false;

      boolean[][] match = new boolean[s1.length()+1][s2.length()+1];
      match[0][0] = true;
      for(int i=0; i<s1.length() + s2.length(); i++ ){
          for(int len1=0; len1 <= i+1 && len1 <= s1.length(); len1++){
          int  len2 = i+1-len1;
          if(len2 > s2.length()) continue;
          if(len2 > 0 && match[len1][len2-1] && s3.charAt(i)==s2.charAt(len2-1) || (len1 > 0 &&
             match[len1-1][len2] && s3.charAt(i) == s1.charAt(len1-1)))
              match[len1][len2] = true;
          }
      }
      return match[s1.length()][s2.length()];
    }

    /*
    //Memory Limit Exceeded
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length()==0 && s2.length()==0) return true;
        boolean result = false;
        if(s1.length()>0 && s1.charAt(0)==s3.charAt(0))
            result = isInterleave(s1.substring(1), s2, s3.substring(1));
        if(result) return true;
        if(s2.length()>0 && s2.charAt(0)==s3.charAt(0))
            result = isInterleave(s1, s2.substring(1), s3.substring(1));
        return result;
    }

     */
}
