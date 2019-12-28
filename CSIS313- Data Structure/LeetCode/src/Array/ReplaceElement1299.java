package Array;

public class ReplaceElement1299 {

    /*
    I terate from the back to the start,
     We initilize max = 1, where max represent the max on the right.
     Each round, we set arr[i] = max, where max is its max on the right.
     Also we update max = max(max, arr[i]), where arr[i] is its original value.
     */


   /* public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, arr[i]);
        }
        return arr;
    }

    */

   public int[] replacementElements(int[] arr){
       for(int i=arr.length-1, max=-1; i>=0; i--){
           max = Math.max(max, arr[i] = max);
       }
       return arr;
   }

   /* C++
   vector<int> replacementElements(vector<int>& arr, int max = -1){
       for(int i=arr.size()-1; i>=0; --1){
           max = max(max, exchange(arr[i], max));
       }
       return arr;
   }

    */
}
