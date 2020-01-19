package String.Easy;

import java.util.HashMap;
import java.util.Scanner;

//run: 1 ms (96%) 41MB
public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String str) {
        char[] ch = pattern.toCharArray();
        String[] strs = str.trim().split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(ch.length != strs.length)  return false;

        for(int i=0; i<ch.length; i++){
            char c = pattern.charAt(i);
            String word = strs[i];
            if(map.containsKey(c)){
               if(!word.equals(map.get(c))) return false;
            }else{
                if(!map.containsValue(word)){
                    map.put(c, word);
                }else{
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String a, b;
        System.out.println("Entre two String: ");
        String pattern = scan.nextLine();
        String str = scan.nextLine();
        System.out.println(wordPattern( pattern, str));
    }
}
