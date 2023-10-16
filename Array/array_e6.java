/*
 * Segregate even and odd numbers
 */

public class array_e6 {
    static void evenInTheBegin(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && i != 0) {
                rotateArray(arr, i);
            }
        }
        for (int i : arr) {
            System.out.print("  " + i);
        }
    }

    static void rotateArray(int[] array, int index) {
        while (index > 0) {
            if(array[index-1] %2 != 0){
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 9, 4, 6, 1, 3, 8, 5 };
        evenInTheBegin(arr);
    }
}
