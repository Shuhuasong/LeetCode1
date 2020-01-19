package String.Easy;

public class ReverseString_344 {

    //Time: O(n)
    //Space: O(1)
    //run time: 1 ms (100%)  54.6MB
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i=0; i<n/2; i++){
            char temp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = temp;
        }
    }
}
