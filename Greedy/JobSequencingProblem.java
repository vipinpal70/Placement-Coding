package Greedy;

import java.util.Arrays;

/*
 * same code for a disjointSet Problem 
 */

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {
    public static int JobSequence(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int maxi = 0;
        for (int i = 0; i < n; i++)
            if (arr[i].deadline > maxi)
                maxi = arr[i].deadline;

        int[] result = new int[maxi + 1];
        for (int i = 1; i <= maxi; i++)
            result[i] = -1;

        int countJob = 0, jobProfit = 0;
        for (int i = 0; i < n; i++)
            for (int j = arr[i].deadline; j > 0; j--)
                if (result[j] == -1) {
                    result[j] = i;
                    countJob++;
                    jobProfit += arr[i].profit;
                    break;
                }
        System.out.println("maximum profit: " + jobProfit);
        return jobProfit;

    }

    public static void main(String[] args) {

        Job[] arr = new Job[5];
        arr[0] = new Job('a', 2, 100);
        arr[1] = new Job('b', 1, 19);
        arr[2] = new Job('c', 2, 27);
        arr[3] = new Job('d', 1, 25);
        arr[4] = new Job('e', 3, 15);

        JobSequence(arr, 5);
    }
}
