// 
public class BestTimeToBuyAndSellStocks {

    public static void main(String args[]){
        int prices[] = { 7, 1, 5, 6, 4 };
        int n = prices.length;
        int max_profit = maxProfit(prices, n);
        System.out.println(max_profit);
    }

    private static int maxProfit(int[] prices, int n) {
        int buy=Integer.MAX_VALUE, profit=Integer.MIN_VALUE,sell=0;

       for(int element:prices){
           buy=Math.min(buy,element);
           sell=element-buy;
           profit=Math.max(sell,profit);
       }
       return profit;
    }
}
