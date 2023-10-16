/*
 * Rearrange array such that even positioned are greater than odd
 */

import java.util.Arrays;

public class array_e4 {

    public static void rearrangeWithoutSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {

            // if index is even but position are odd
            if (i % 2 == 0) {
                if (arr[i] > arr[i - 1]) {

                    // swap two elements
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }

            // if index is odd but position are even
            else {
                if (arr[i] < arr[i - 1]) {

                    // swap two elements
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void rearrangeArray(int[] arr) {

        Arrays.sort(arr);
        int[] newArr = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                newArr[i] = arr[i];
                count++;
            } else if (i % 2 == 0 && i != 0) { // for odd position
                newArr[i] = arr[count];
                count++;

            } else { // for even position
                newArr[i] = arr[(arr.length) - (count)];
            }
        }

        for (int i : newArr) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 10, 13, 12, 15, 18, 19, 11, 17 };
        // rearrangeArray(arr);
        System.out.println("");
        rearrangeWithoutSort(arr, arr.length);

    }
}
