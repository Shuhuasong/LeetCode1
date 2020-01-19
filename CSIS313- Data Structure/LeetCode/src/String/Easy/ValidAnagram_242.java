package String.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram_242 {

    //Time: O(n)
    //Space: O(1)

    //run: 4ms (80%)
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] ch = new int[26];
        for(int i=0; i<s.length(); i++){
            ch[s.charAt(i)-'a']++;
            ch[t.charAt(i)-'a']--;
        }

        for(int i : ch)
            if(i != 0) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String a, b;
//        System.out.println("Entre two String: ");
////        a = scan.nextLine();
////        b = scan.nextLine();
        a = "nl";
        b = "cx";
        System.out.println(isAnagram(a, b));
    }

//Time: O(nlog n) Space: O(n)
//Run: 6ms (49%)
  /*  public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1); //O(nlog n)
        Arrays.sort(t1);

        int n = s1.length;
        int m = t1.length;
        if(n!=m)
            return false;
        else{
            for(int i=0; i<s1.length; i++){
                if(s1[i] != t1[i]) return false;
            }
        }
        return true;
    }

   */

  /*  public boolean isAnagram(String s, String t) {
        if(s==null || t==null)  return false;
        if(s.length()!=t.length()) return false;
        int n = s.length();
        //HashSet<Character> set = new HashSet<>();
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(char c : s.toCharArray()){
            sArr[c-'a']++;
        }
        for(char k : t.toCharArray()){
            tArr[k-'a']++;
        }
        for(int i=0; i<s.length(); i++)
            if(sArr[i] != tArr[i]) return false;

        return true;
    }

   */
}
