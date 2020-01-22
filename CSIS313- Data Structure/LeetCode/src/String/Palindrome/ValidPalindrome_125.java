package String.Palindrome;

public class ValidPalindrome_125 {

    //run time: 2ms (99%)
    //Time Complexity: O(n)  Space: O(n)
    public  boolean isPalindrome(String s){
        if(s==null || s.length()==0) return true;
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left <= right){
            while(left<right && !isAlpha(arr[left])) left++;
            while(left<right && !isAlpha(arr[right])) right--;

            if(Character.toLowerCase(arr[left])!=Character.toLowerCase(arr[right])) return false;

            left++;
            right--;
        }
        return true;
    }

    public boolean isAlpha(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >='0' && c <= '9';
    }
}
