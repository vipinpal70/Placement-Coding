/*
 * buy and sell stock to get maximum profit
 */
public class stockBuySell {
    public static void buySell(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int maxProfitIndex = 0;
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            int in = largest(prices, i);
            if (prices[i] >= prices[in]) {
                profit[i] = 0;
            } else {
                profit[i] = largest(prices, i);
            }
            if (profit[i] != 0) {
                int pr = prices[profit[i]] - prices[i];
                if (pr > maxProfit) {
                    maxProfit = pr;
                    maxProfitIndex = i;
                }
                // System.out.print(" : " + pr);
            }
    
        }
        // for (int i : profit) {
        // System.out.print(" " + i);
        // }
        System.out.println("Buying Price  " + prices[maxProfitIndex] + " at the " + maxProfitIndex + " Day");
        System.out.println(
                "Selling Price  " + prices[profit[maxProfitIndex]] + " at the " + profit[maxProfitIndex] + " Day");
        System.out.println("Total Profit Per Share : " + (prices[profit[maxProfitIndex]] - prices[maxProfitIndex]));
    }

    public static int largest(int[] arr, int start) {
        int result = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i < arr.length; i++) {
            if (result < arr[i]) {
                result = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        buySell(prices);

    }
}

