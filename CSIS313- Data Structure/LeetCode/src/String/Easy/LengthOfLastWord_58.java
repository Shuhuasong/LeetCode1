package String.Easy;

public class LengthOfLastWord_58 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //run time: 1ms (48%), 36.5MB
  /*  public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return (strs.length==0) ? 0 : strs[strs.length-1].length();
   }

   //
    public int lengthOfLastWord(String s) {
        String S = s.trim();
        String[] strs = S.split(" ");
        int lastIndex = strs.length-1;
        return strs[lastIndex].length();
    }

   */

    //run time: 0 ms, 41.3MB
    public int lengthOfLastWord(String s) {
        s = s.trim();
        for(int i=s.length()-1; i>=0; i--){
            if(s.substring(i,i+1).equals(" ")){
                return s.length()-1 - i;
            }
        }
        return s.length();
    }

}
