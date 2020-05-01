package Divide_and_Conquer;

public class _744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(letters[mid] > target) high = mid;
            else low = mid + 1;
        }
        if(low==letters.length-1 && letters[low] <= target)
            return letters[0]; //Letters also wrap around
        else
            return letters[low];
    }
}
