/*
 * Rearrange positive and negative numbers in O(n) time and O(1) extra space
 */
public class array_m2 {

    static void rearrangeArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                int p = searchPositive(arr, i);
                rotateArray(arr, p, i);
            }
            if (i > 0 && i % 2 == 0) {
                int p = searchPositive(arr, i);
                rotateArray(arr, p, i);
            }
            if (i % 2 != 0) {
                int p = searchNegative(arr, i);
                rotateArray(arr, p, i);
            }
        }
    }

    static void rotateArray(int[] arr, int value, int index) {
        int tp = arr[index];
        arr[index] = arr[value];
        arr[value] = tp;
    }

    static int searchPositive(int[] arr, int x) {
        int re = 0;
        int rr = 0;
        for (int i = x; i < arr.length; i++) {
            if (arr[i] > re) {
                re = arr[i];
                rr = i;
            }
        }
        return rr;
    }

    static int searchNegative(int[] arr, int y) {
        int re = 0;
        int rr = 0;
        for (int i = y; i < arr.length; i++) {
            if (arr[i] < re) {
                re = arr[i];
                rr = i;
            }
        }
        return rr;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        rearrangeArr(arr);
        for (int i : arr) {
            System.out.print(" : " + i);
        }
    }
}
