package backtracking;

import java.util.ArrayList;
import java.util.List;

public class palindromePartition {
    public static void palindromePartMethod(int index, String str, List<String> ds, List<List<String>> ans) {
        // base case
        if (index == str.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        // recursive step
        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                ds.add(str.substring(index, i + 1));
                palindromePartMethod(index + 1, str, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        List<String> rs = new ArrayList<>();
        // String str = "aabb";
        String str = "nitin";
        palindromePartMethod(0, str, rs, ans);
        System.out.println();
        System.out.println(ans);
        System.out.println();
    }
}
