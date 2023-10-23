package backtracking;

import java.util.ArrayList;

public class kthPermutationSequence {
    public static void kthPermutationSeq(int n, int k) {
        ArrayList<Integer> ds = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            ds.add(i);
        }
        ds.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans = ans + (ds.get(k / fact));
            ds.remove(k / fact);
            if (ds.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / ds.size();
        }
        System.out.println();
        System.out.println(ans);
        System.out.println();
    }

    public static void main(String[] args) {
        kthPermutationSeq(4, 17);
    }
}
