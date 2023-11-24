package Greedy;

import java.util.Vector;
public class MinimumNomOfCoin {
    
/* 
*Java program to find minimum number of denominations
*/


   
    static int deno[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
    static int n = deno.length;

    static void findMin(int V) {
        // Initialize result
        int notes = 0;
        Vector<Integer> ans = new Vector<>();

        // Traverse through all denomination
        for (int i = n - 1; i >= 0; i--) {
            // Find denominations
            while (V >= deno[i]) {
                notes++;
                V -= deno[i];
                ans.add(deno[i]);
            }

            //-------> ONly for Count Notes 
            // if(V >= deno[i] && V != 1){
            //     int newV = V % deno[i];
            //     notes += V / deno[i];
            //     V = newV;
            // }
        }
        // notes++;

        // Print result
        System.out.println("total notes: " + notes);
        // for (int i = 0; i < ans.size(); i++) {
        //     System.out.print(
        //             " " + ans.elementAt(i));
        // }
    }


    public static void main(String[] args) {
        int n = 5731;
        System.out.print(
                "Following is minimal number "
                        + "of change for " + n + ": ");
        findMin(n);
    }
}


