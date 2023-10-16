package sorting;

public class bubbleSort {
    public static void bSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int swap = 0;
            for (int j = 0; j < arr.length - (i + 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int tp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tp;
                    swap++; // condition for sorted arrays
                }
            }
            // for already sorted array
            if (swap == 0) {
                System.out.println("inside ");
                break;
            }

        }
        // for printing array here
        for (int i : arr) {
            System.out.print("   ");
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 8, 11, 12, 14, 16, 23, 45 };
        bSort(array);
    }
}
