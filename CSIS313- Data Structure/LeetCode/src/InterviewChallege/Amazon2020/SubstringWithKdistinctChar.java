package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class SubstringWithKdistinctChar {
    public SubstringWithKdistinctChar(){}

    public static List<String> getSubstring(String str, int k){
        int n = str.length();
        List<String> result =  new ArrayList<>();
        if(n < k) return new ArrayList<>(result);

        for(int i=0; i<n; i++){
            Set<Character> set = new HashSet<>();
            set.add(str.charAt(i));
            for(int j=i+1; j<n; j++){
                set.add(str.charAt(j));
                if(set.size()==k){
                    result.add(str.substring(i, j+1));
                }
            }
        }

        return result;
    }


    public static void main(String args[]) throws IOException {
        SubstringWithKdistinctChar  sub = new SubstringWithKdistinctChar ();
        String str = "pqpqs";
        int k = 2;
        List<String> result = getSubstring(str, k);
        for(String s : result){
            System.out.print(s + " ");
        }
    }
}
