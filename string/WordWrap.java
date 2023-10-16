package string;

import java.util.HashMap;
import java.util.Map;

public class WordWrap {

    public static Map<String, Integer> map = new HashMap<>();

    public static int solve(int[] nums, int i, int k, int rem) {
        if (i >= nums.length)
            return 0;
        // if(dp[i][rem]!=-1) return dp[i][rem];
        String key = i + "$$" + rem;
        if (map.containsKey(key))
            return map.get(key);
        if (nums[i] > rem) {
            int temp = (rem + 1) * (rem + 1) + solve(nums, i + 1, k, k - nums[i] - 1);
            map.put(key, temp);
            return temp;
        } else {
            int temp1 = (rem + 1) * (rem + 1) + solve(nums, i + 1, k, k - nums[i] - 1);
            int temp2 = solve(nums, i + 1, k, rem - nums[i] - 1);
            int temp3 = Math.min(temp1, temp2);
            map.put(key, temp3);
            return temp3;
        }
    }

    public static int solveWordWrap(int[] nums, int k) {
        // Code here

        return solve(nums, 0, k, k);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 5 };
        int k = 6;
        System.out.println(solveWordWrap(nums, k));
    }
}
