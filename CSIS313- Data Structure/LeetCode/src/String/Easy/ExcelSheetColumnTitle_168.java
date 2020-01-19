package String.Easy;

public class ExcelSheetColumnTitle_168 {

    //run: 0ms (100%) 39.7MB
    public String convertToTitle(int n) {
      StringBuilder sb = new StringBuilder();
      while(n>0){
          sb.append((char)('A'+n%26));
          n--;
          n /= 26;
      }
      return sb.reverse().toString();
    }

    //7ms (100%) 41.2MB
 /*   public String convertToTitle(int n) {
        String res = "";
        while(n>0){
            char ch = (char) ((n-1)%26 +65);
            n = (n-1)/26;
            res = ch + res;
        }
        return res;
    }

  */
}
