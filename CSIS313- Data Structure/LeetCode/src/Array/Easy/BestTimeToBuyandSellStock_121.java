package Array.Easy;

public class BestTimeToBuyandSellStock_121 {
    //Time: O(n) Space: O(1)
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=0; i<prices.length; i++){
            if(prices[i]>minPrice){
                maxProfit = Math.max(prices[i]-minPrice, maxProfit);
            }
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    //run: 251ms
  /*  public int maxProfit(int[] prices) {
       if(prices==null || prices.length==0) return 0;
        int maxProfit = 0;

       for(int i=0; i<prices.length-1; i++){
           for(int j=i+1; j<prices.length; j++){
              maxProfit = Math.max(prices[j]-prices[i], maxProfit);
           }
       }
        return maxProfit;
    }
    */
}

/*
1. find max, min
2. before: min    after: max

*/

