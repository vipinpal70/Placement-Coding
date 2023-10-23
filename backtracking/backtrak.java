package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Decision , Optimization, Enumeration(total path)
 * 
 */
public class backtrak {

    public static void arrayTrack(int arr[], int index, int value) {
        // base case
        if (index == arr.length) {
            printArray(arr);
            return;
        }
        // kaam
        arr[index] = value;
        arrayTrack(arr, index + 1, value + 1);
        // backtraking step
        arr[index] = arr[index] - 2;

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println("");
    }

    // find & print all subset of a given string
    public static void subSet(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {

                System.out.println(ans);
            }
            return;
        }

        // kaam recurtion
        // yes choise
        subSet(str, ans + str.charAt(i), i + 1);

        // no choise
        subSet(str, ans, i + 1);

    }

    // find permutations of string
    public static void strPermutations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // kaam recurtion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // remove curr character from string
            String newstr = str.substring(0, i) + str.substring(i + 1);
            strPermutations(newstr, ans + curr);
        }

    }

    // find permutations of of Array
    public static void arrayPermutations(int[] array, ArrayList<Integer> ds, List<List<Integer>> ans, boolean[] check) {
        // base case
        if (array.length == ds.size()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        // recursive step
        for (int i = 0; i < check.length; i++) {
            if (check[i] == false) {
                check[i] = true;
                ds.add(array[i]);
                arrayPermutations(array, ds, ans, check);
                ds.remove(ds.size() - 1);
                check[i] = false;
            }

        }
    }

    private static void recurPermutation(int index, int[] nums, List<List<Integer>> ans) {
        // base case
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {

                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        // recursive case
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermutation(index + 1, nums, ans);
            swap(i, index, nums);
        }

    }

    private static void swap(int i, int index, int[] nums) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }

    public static void main(String[] args) {

        // int[] arr = new int[5];
        // arrayTrack(arr, 0, 1);
        // printArray(arr);
        // String stri = "abc";
        // subSet(stri, "", 0);
        // strPermutations(stri, "");

        // --------permutation of an Array
        // int[] array = { 1, 2, 3 };
        // List<List<Integer>> ans = new ArrayList<>();
        // boolean[] check = new boolean[3];
        // arrayPermutations(array, new ArrayList<Integer>(), ans, check);
        // System.out.println(ans);

        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = new ArrayList<>();
        recurPermutation(0, arr, ans);
        System.out.println(ans);

    }
}
