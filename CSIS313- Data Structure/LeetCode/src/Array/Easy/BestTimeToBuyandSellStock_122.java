package Array.Easy;

public class BestTimeToBuyandSellStock_122 {
    //Time: O(n)
   /* public int maxProfit(int[] prices) {
      if(prices==null || prices.length==0) return 0;
      //int sum = 0;
      int profit = 0;
      int minPrice = prices[0];
      int i=0;
        while(i<prices.length){
            if(prices[i]>minPrice){
                profit += prices[i]-minPrice;
               // sum += profit;
            }
             minPrice = prices[i];
             i++;
        }
        return profit;
    }
    */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int max = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i]-prices[i-1];
            }
        }
        return max;
    }
}
