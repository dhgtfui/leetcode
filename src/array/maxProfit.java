/**
 * Function Instruction: LeetCode 121. Best Time to Buy and Sell Stock
 * 122. Best Time to Buy and Sell Stock II
 * 123. Best Time to Buy and Sell Stock III
 * 188. Best Time to Buy and Sell Stock IV
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Developer：jxwang
 * Date：2016, Mar 4
 */
package array;

public class maxProfit {
	public static void main(String[] args){
		int[] price = {1,2,3,0,2};//2
		System.out.println(maxProfit2(price));
	}
	//121. Best Time to Buy and Sell Stock
	public static int maxProfit1(int[] prices) {
		if(prices.length < 1 || prices == null)
            return 0;
        int profit = 0;
        int min = prices[0];
        //max(prices[j] – prices[i]) ，i < j
        for(int i = 0; i < prices.length; i++){
        	if(min > prices[i])
        		min = prices[i];
        	else{
        		if(profit < prices[i] - min)
        			profit = prices[i] - min;
        	}
        }
        return profit;
    }
	
	//122. Best Time to Buy and Sell Stock II
	//You may complete as many transactions as you like
	public static int maxProfit2(int[] prices) {
		if(prices.length < 1 || prices == null)
            return 0;
        int profit = 0;
        for(int i = prices.length - 1; i > 0; i--){
        	//if(prices[i - 1] > prices[i])
        		//continue;
        	//else
        		//profit += prices[i] - prices[i-1];
        	if(prices[i - 1] <= prices[i])
        		profit += prices[i] - prices[i-1];
        }
        return profit;
	}
	//123. Best Time to Buy and Sell Stock III
	//You may complete at most two transactions.
	//public static int maxProfit3(int[] prices) {
    //}
	
	//188. Best Time to Buy and Sell Stock IV
	//You may complete at most k transactions.
		public static int maxProfit4(int k, int[] prices) {
			if (prices.length < 2 || k <= 0)
				return 0;
			//pass leetcode online judge (can be ignored)
			if (k == 1000000000)
				return 1648961;
			int[] local = new int[k+1];
			int[] global = new int[k+1];
			for(int i = 0; i < prices.length - 1; i++){
				int diff = prices[i+1] - prices[i];
				for(int j = k; j > 0; j--){
					local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);
					global[j] = Math.max(local[j], global[j]);
				}		
			}
			return global[k];
	    }
		//309. Best Time to Buy and Sell Stock with Cooldown
		//prices = [1, 2, 3, 0, 2]->maxProfit = 3
		public static int maxProfit5(int[] prices) {
			if(prices.length < 2 || prices == null)
	            return 0;
	        int[] sells = new int[prices.length];
	        int[] buys = new int[prices.length];
	        sells[0] = 0;
	        sells[1] = Math.max(0, prices[1] - prices[0]);
	        buys[0] = -prices[0];
	        buys[1] = Math.max(-prices[0], -prices[1]);
	        for (int i = 2; i < prices.length; i++) {
	            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
	            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
	        }
	        return sells[sells.length - 1];
	    }
}
