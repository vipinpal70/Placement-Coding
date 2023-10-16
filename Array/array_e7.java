/*
 * Reversal algorithm for array rotation
 */
public class array_e7 {
    static void rotateArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int tp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tp;
        }
    }

    // using two block swap approach

    static void blockSwap(int[] arr, int d) {
        if (d == 0) {
            return;
        }

        int n = arr.length;
        d = d % n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);

    }

    /* Function to reverse arr[] from index start to end */
    static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // for (int i = 0; i < 2; i++) {
        // rotateArray(arr);
        // }

        blockSwap(arr, 2);

        for (int i : arr) {
            System.out.print("  " + i);
        }
    }
}
