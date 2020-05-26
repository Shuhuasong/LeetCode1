package String.Medium;

import java.util.Arrays;

public class _567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int len1 = s1.length(), len2 = s2.length();
        for(int i=0; i<len1; i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(count1, count2)) return true;
        for(int j=len1; j<len2; j++){
            count2[s2.charAt(j)-'a']++;
            count2[s2.charAt(j-len1)-'a']--;
            if(Arrays.equals(count1, count2)) return true;
        }
        return false;
    }
}
