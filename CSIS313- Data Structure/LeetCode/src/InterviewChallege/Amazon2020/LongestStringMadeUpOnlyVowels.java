package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestStringMadeUpOnlyVowels {
//Solution #1
    public void longestOnlyVowels() {
        String s = "earthproblem";
//earthproblem
//letsgosomewhere
        String vowels = "aeiou";
        int maxlength = Integer.MIN_VALUE;
        int secondMaxLength = Integer.MIN_VALUE;
        int index = 0;
        while (index < s.length()) {
            if (vowels.indexOf(s.charAt(index)) != -1) {
                int nextIndex = index + 1;
                while (nextIndex < s.length() && vowels.indexOf(s.charAt(nextIndex)) != -1) {
                    nextIndex++;
                }
                if (nextIndex - index > maxlength) {
                    secondMaxLength = maxlength;
                    maxlength = nextIndex - index;
                } else if (nextIndex - index > secondMaxLength) {
                    secondMaxLength = nextIndex - index;
                }
                index = nextIndex;
            } else {
                index++;
            }
        }
        System.out.println("length is.." + (maxlength + secondMaxLength));
    }

 /*   public static int getMov(char[] arr){

        char[] arr = new char{e,a,r,t,h,p,r,o,b,l,e,m,o,o};
        int startIndex = 0;
        int endIndex = arr.length-1;
        Set hs = new HashSet<Character>();
        hs.add('a');hs.add('e');hs.add('i');hs.add('o');hs.add('u');

        while(hs.contains(letters[start]))
            start++;
        while(hs.contains(letters[end]))
            end--;
        int max = Integer.MIN_VALUE;
        // earthproblemoo
        for(int i = start;i<=end;i++){
            int tempCount = 0;
            while(hs.contains(arr[i])){
                tempCount++;
            }
            max = max>tempCount?max:tempCount;
            i+=tempCount;
        }
        return start+(endIndex-end)+max;
    }
  */
//Solution #2
    static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    static int solution(String S) {
        int left = 0, right = S.length() - 1, res = 0;
        while (left < right) {
            if (vowels.contains(S.charAt(left))) {
                left++;
                res++;
            } else if (vowels.contains(S.charAt(right))) {
                right--;
                res++;
            } else break;
        }

        res += longestVowelSubstring(S, left, right);

        return res;
    }

    private static int longestVowelSubstring(String S, int left, int right) {
        int res = 0, max = 0;
        for (int k = left + 1; k < right; k++) {
            if (vowels.contains(S.charAt(k))) {
                if (res == 0) res = 1;
                if (vowels.contains(S.charAt(k - 1))) {
                    res++;
                }
                max = Integer.max(max, res);
            } else {
                res = 0;
            }
        }
        return max;
    }
    public static void main(String args[]) throws IOException {
        LongestStringMadeUpOnlyVowels test = new LongestStringMadeUpOnlyVowels();
        test.longestOnlyVowels();
    }
}

//https://leetcode.com/discuss/interview-question/233724/Amazon-online-assessment-Longest-string-made-up-of-only-vowels
