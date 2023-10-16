package sorting;

public class countSort {
    public static void cSort(int[] arr) {
        int N = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i]);
        }
        // System.out.println(max);
        int[] count = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            count[arr[i]]++;
        }

        // UPDATE array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        System.out.println();
        // print array
        for (int i = 0; i < max; i++) {
            // System.out.print(i + " " + count[i]);
            System.out.println();
        }
        System.out.println();
        int[] output = new int[N];

        // sorting
        for (int i = N - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        // print array
        // for (int i = 0; i < N; i++) {
            // System.out.print(" " + output[i]);
        // }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 0, 2, 3, 0, 3 };
        cSort(arr);
    }
}
