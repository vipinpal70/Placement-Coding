
/*
 * Rearrange an array in maximum minimum form using Two Pointer Technique

 */
import java.util.Arrays;

public class array_e5 {
    static void rearrangeArray(int[] arr) {
        Arrays.sort(arr);
        // for (int i : arr) {
        // System.out.print(i+" ");
        // }

        int tempArr[] = new int[arr.length];
        int start = 0, last = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                tempArr[i] = arr[last];
                last--;
            } else {
                tempArr[i] = arr[(start)];
                start++;

            }
        }
        System.out.println("");
        for (int i : tempArr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 13, 12, 15, 18, 19, 11, 17 };
        rearrangeArray(arr);
    }
}
