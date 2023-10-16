/*
 * Move all zeroes to end of array
 */
public class array_e3 {
    static void moveZeros(int[] arr) {
        int count = 0;
        int length = arr.length;
        // counting all non-zero elements in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // setting non-zero elements in the beginning of array
            }
        }
        while (count < length) {
            arr[count++] = 0; // setting remaining space with zero's

        }
        // for loop printing elements of array
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 12, 0, 1, 10, 34, 0, 45, 0, 78 };
        moveZeros(arr);
    }
}
