package String.Easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        //Time: O(n) , Space: O(1)
        //6ms (38%) 47.9MB
      if(s==null || s.length()==0) return s;
      //String vowel = "aeiouAEIOU";
      Set<Character> vowels = new HashSet<>();
      vowels.add('a');  vowels.add('A');
      vowels.add('e');  vowels.add('E');
      vowels.add('i');  vowels.add('I');
      vowels.add('o');  vowels.add('O');
      vowels.add('u');  vowels.add('U');
      char[] ch = s.toCharArray();
      int start = 0;
      int end = ch.length-1;
      while(start < end){
          if(!vowels.contains(ch[start])) { start++; continue; }
          if(!vowels.contains(ch[end])) { end--; continue; }
          char temp = ch[start];
          ch[start++] = ch[end];
          ch[end--] = temp;

      }
      String res = new String(ch);
      return res;
    }

//run time: 3ms (78%) 48.2 MB
 /*   public String reverseVowels(String s) {
        if(s==null || s.length()==0) return s;
        char[] ch = s.toCharArray();
        int l = 0;
        int r = ch.length-1;
        while(l<r){
            if(isVowel(s.charAt(l))){
                while(l <= r && !isVowel(s.charAt(r))){
                    r--;
                }
                swap(s.charAt(l), s.charAt(r));
                    r--;
            }

            l++;
        }
        return new String(ch);
    }

    public void swap(char a, char b){
        char temp = a;
        a = b;
        b = temp;
    }


    public boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }

    }

  */
}
