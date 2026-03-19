/*
========================================
🧠 Best Time to Buy and Sell Stock
========================================

📌 Problem:
Given an array prices[], where prices[i] is the price of a stock on day i,
find the maximum profit by buying once and selling once.

----------------------------------------
🥉 1. Brute Force
👉 Technique: Check all pairs
⏱ Time: O(n^2)
----------------------------------------
*/

public class TimeBuysell {

    // 🥉 Brute Force
    public static int brute(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    /*
    ----------------------------------------
    🥈 2. Better Approach
    👉 Technique: Track minimum before each day
    ⏱ Time: O(n)
    ----------------------------------------

    💡 Idea:
    For every day, check the minimum price before it
    */

    public static int better(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                min = Math.min(min, prices[j]);
            }

            int profit = prices[i] - min;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    /*
    ----------------------------------------
    🥇 3. Optimal Approach (Best)
    👉 Technique: Greedy + Running Minimum
    ⏱ Time: O(n)
    ⏱ Space: O(1)
    ----------------------------------------

    💡 Idea:
    - Track minimum price so far
    - Calculate profit at each step
    */

    public static int optimal(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - buy;

            profit = Math.max(profit, cost);
            buy = Math.min(buy, prices[i]);
        }

        return profit;
    }

    /*
    ----------------------------------------
    🧪 Example:
    prices = [7,1,5,3,6,4]

    Buy at 1, Sell at 6 → Profit = 5
    ----------------------------------------
    */

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Brute Force: " + brute(prices));
        System.out.println("Better: " + better(prices));
        System.out.println("Optimal: " + optimal(prices));
    }
}