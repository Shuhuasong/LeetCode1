package String.Easy;

public class ReverseWordsInaStringII_186 {
    public void reverseWords(char[] s){
      reverse(s, 0, s.length-1);
    }

    private void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
