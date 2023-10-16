/*
 * Sort an array in wave form
 */
public class array_e9 {

    static void waveSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (i == 0 && ((arr[i] < arr[i + 1]))) {
                swap(arr, i, i + 1);
            }

            if ((i % 2 == 0 && i != 0) && (arr[i] < arr[i + 1])) {
                swap(arr, i, i + 1);
                // System.out.println(": " + i);
            }
            if ((i % 2 != 0) && (arr[i] > arr[i + 1])) {
                swap(arr, i, i + 1);
            }
        }
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    static void swap(int[] arr, int x, int y) {
        int tp = arr[x];
        arr[x] = arr[y];
        arr[y] = tp;
    }

    public static void main(String[] args) {
        int[] input = { 20, 10, 8, 6, 4, 2 };
        waveSort(input);

    }
}
