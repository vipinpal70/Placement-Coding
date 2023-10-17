package backtracking;

import java.util.ArrayList;

/*
 * All Important question of backtracking from the geeksforgreeks 
 */
public class gfgBackProblem {

    /*
     * Print all subsets of a given Set or Array
     */
    public static void allSubsetPrint(int[] arr, int i, ArrayList<Integer> subSet) {
        // ArrayList<Integer> subset = new ArrayList<Integer>();
        // base case
        if (i >= 0 && i == arr.length) {
            System.out.println(subSet);
            // subSet.clear();
            return;
        }

        // recursive case
        // yes choise
        subSet.add(arr[i]);
        allSubsetPrint(arr, i + 1, subSet);

        // no choise
        subSet.remove(subSet.size() - 1);
        allSubsetPrint(arr, i + 1, subSet);

    }

    /*
     * Function to find the subsets of the given array using bit manipulation
     */
    public static void findSubsets(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Loop through all possible subsets
        // using bit manipulation
        for (int i = 0; i < (1 << n); i++) {

            // Loop through all elements
            // of the input array
            for (int j = 0; j < n; j++) {

                // Check if the jth bit is set
                // in the current subset
                if ((i & (1 << j)) != 0) {

                    // If the jth bit is set,
                    // add the jth
                    // element to the subset
                    System.out.print(nums[j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        // allSubsetPrint(arr, 0, new ArrayList<>());
        findSubsets(arr);
    }
}
