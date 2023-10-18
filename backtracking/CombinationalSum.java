package backtracking;

import java.util.List;
import java.util.ArrayList;

/*
 * Combinational Sum
 */
public class CombinationalSum {
    public static void findUniqueCombination(int ind, int[] arr, int x, List<List<Integer>> ans, List<Integer> ds) {
        // base case
        if (ind == arr.length) {
            if (x == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // recursive case
        if (arr[ind] <= x) {
            ds.add(arr[ind]);
            findUniqueCombination(ind, arr, x - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findUniqueCombination(ind + 1, arr, x, ans, ds);

    }

    public static List<List<Integer>> CombinationalSumMethod(int[] candidates, int x) {
        List<List<Integer>> ans = new ArrayList<>();

        findUniqueCombination(0, candidates, x, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8 };
        int x = 8;
        List<List<Integer>> re = new ArrayList<>();
        re = CombinationalSumMethod(arr, x);
        System.out.println(re);

    }
}
