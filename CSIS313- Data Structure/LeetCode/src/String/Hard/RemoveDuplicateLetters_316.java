package String.Hard;

import java.util.Stack;

public class RemoveDuplicateLetters_316 {

    //5ms (37.55%)
    //Time O(n^2)
    //Space: O(n)
    public String removeDuplicateLetters(String s){
        if(s.length() <= 1) return s;
        Stack<Character> stack = new Stack<>();
        int[] count = countFreq(s);

        for(char ch : s.toCharArray()){
            count[ch-'a']--;
            if(stack.contains(ch)){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>ch && count[stack.peek()-'a']>0){
                stack.pop();
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }

    public int[] countFreq(String s){
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        return count;
    }
}
