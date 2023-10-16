package sorting;

public class insertionSort {
    public static void inSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;

            // finding out the correct pos to insert
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = current;
        }
        // printing array here
        for (int i : arr) {
            System.out.print("   ");
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 4, 3, 2, 6, 8, 7, 1 };
        inSort(array);
    }
}
