package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Fractional Knapsack problem
 */
public class FractionalKnapsack {
    public static void solveKnapsack(int[] profit, int[] weight, int totalWeight) {

        double[][] ratio = new double[profit.length][2];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = profit[i] / (double) weight[i];
        }

        // sort ratio according to 2nd colunm of ratio array

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // selecting ratio's

        int index;
        double ans = 0.0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            index = (int) ratio[i][0]; 

            if (totalWeight >= weight[index]) {
                double totalValue = weight[index] * ratio[i][1]; 
                ans += totalValue;
                totalWeight = totalWeight - weight[index];

            } else {
                double vl = (profit[index] / weight[index]) * totalWeight;
                ans += vl;
            }
        }

        System.out.println("Maximum Profit : " + ans);
    }

    public static void main(String[] args) {
        int[] profit = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };

        int totalWeight = 50;

        solveKnapsack(profit, weight, totalWeight);
    }
}