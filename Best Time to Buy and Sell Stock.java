public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null)
            return 0;
        int diff= 0;
        int min_price = prices[0];
        for (int i = 1; i < prices.length; i++){
            if(prices[i] < min_price)
                min_price = prices[i];
            else if(prices[i] > min_price){
                int temp = prices[i] - min_price;
                if(temp > diff)
                    diff = temp;
            }
            
        }
        return diff;
    }
}