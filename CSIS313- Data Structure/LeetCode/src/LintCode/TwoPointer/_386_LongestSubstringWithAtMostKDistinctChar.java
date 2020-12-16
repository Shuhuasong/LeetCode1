package LintCode.TwoPointer;

import java.util.Collections;
import java.util.HashMap;

public class _386_LongestSubstringWithAtMostKDistinctChar {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int n = s.length();
        if (n*k == 0) return 0;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 1;

        while (right < n) {
            // add new character and move right pointer
            hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}

/*

Algorithm

Now one could write down the algortihm.

Return 0 if the string is empty or k is equal to zero.
Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
While right pointer is less than N:
Add the current character s[right] in the hashmap and move right pointer to the right.
If hashmap contains k + 1 distinct characters, remove the leftmost character from the hashmap and move the left pointer so that sliding window contains again k distinct characters only.
Update max_len.
 */
