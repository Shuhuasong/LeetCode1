package LintCode.String;

public class _891_ValidPalindromeII {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    class Pair{
        int left, right;
        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public boolean validPalindrome(String s) {
        // Write your code here
        if(s==null) return false;
        Pair pair = findDifference(s, 0, s.length()-1);
        if(pair.left >= pair.right) return true;
        return isPalindrome(s, pair.left+1, pair.right) || isPalindrome(s, pair.left, pair.right-1);
    }

    private Pair findDifference(String s, int left, int right){
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return new Pair(left, right);
    }
    private boolean isPalindrome(String s, int left, int right){
        Pair pair = findDifference(s, left, right);
        return pair.left >= pair.right;
    }
}
