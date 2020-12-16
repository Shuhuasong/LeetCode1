package LintCode.String;

public class _415_ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if(s==null) return false;
        int left = 0, right = s.length()-1;
        while(left < right){
            while( left < right && !isValidChar(s.charAt(left))){
                left++;
            }
            while(left < right && !isValidChar(s.charAt(right))){
                right--;
            }
            if(left < right && !isEqual(s, left, right)){
                return false;
            }
            left++;
            right--;
        }
        return left>=right;
    }

    private boolean isValidChar(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
    private boolean isEqual(String s, int left, int right){
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right));
    }
}
