package SlicingWindow;

public class _1052_GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, save = 0, n = customers.length; //save: the number of customer ask to come back
        for(int i=0; i<n; i++){
            if(grumpy[i]==0) { sum += customers[i]; }
        }
        int maxSum = sum;
        for(int j=0; j<X; j++){ //creat a window
            if(grumpy[j]==1) { save += customers[j]; }
        }
        sum += save;
        if(sum > maxSum) { maxSum = sum; }
        int l = 0;
        for(int r=X; r<n; r++){
            if(grumpy[r]==1) { sum += customers[r]; }//add the right side's number
            if(grumpy[l]==1) { sum -= customers[l]; }//remove the left side's number
            if(sum > maxSum) maxSum = sum;
            l++;
        }
        return maxSum;
    }

    /*
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
      int sum = 0, cur = 0, max = 0;
      for(int i=0, j=0; j<customers.length; j++){
          if(grumpy[j]==0) { sum += customers[j]; }
          else{
              cur += customers[j];
          }

          while(j-i+1==X){
             max = Math.max(cur, max);
             if(grumpy[i] == 1){
                 cur -= customers[i];
             }
                i++;
          }
       }
        return sum+max;
    }
     */
}


/*
grumpy :     0  1   0  1  0  1  0  1
customeres:  1  0   1  2  1  1  7  5

grumpy:      0  0   0  2  0  1  0  5   find a max window
*/
