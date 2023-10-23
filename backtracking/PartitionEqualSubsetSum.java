package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Partition Equal Subset Sum
 */
public class PartitionEqualSubsetSum {
    public static void partitionEqual(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int s1 = arr[0];
        int s2 = arr[j];
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<>();
      
        while (i <= j) {
          
            if (s1 < s2) {
                l1.add(arr[i]);
                s1 += arr[i + 1];
                i++;
            }
            if (s1 > s2) {
                l2.add(arr[j]);
                s2 += arr[j - 1];
                j--;
            }
            if (s1 == s2) {
                l1.add(arr[i]);
                l2.add(arr[j]);
                ans.add(l1);
                ans.add(l2);
                i++;
                j--;
            }

        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 11, 5 };
        partitionEqual(arr);
    }
}
