package sorting;

public class selectionSort {
    public static void sSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            // for already sorted array
            if (minPos == 0) {
                System.out.println(" inside " + i);
                break;
            }
            // swap here
            int tp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = tp;
        }
        // printing array here
        for (int i : arr) {
            System.out.print("   ");
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        int[] array = { 15, 41, 12, 19, 23, 45, 51, 5, 8, 9, 11 };
        // int[] array = { 5, 8, 11, 12, 14, 16, 23, 45 };
        sSort(array);
    }
}
