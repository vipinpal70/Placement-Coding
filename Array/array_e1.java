/*
 * Find the largest three elements in an array
 */

public class array_e1 {

    public static void largetsThree(int[] arr) {
        // int[] result = new int[3];
        int first, second, third;

        if (arr.length < 3) {
            System.out.println("Invalid Input !");
            return;
        }
        third = first = second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            /* If current element is greater than first */
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second then update second */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            }

            else if (arr[i] > third)
                third = arr[i];
        }

        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }

    public static void main(String[] args) {
        int arr[] = { 12, 13, 1, 10, 34, 1 };
        largetsThree(arr);
    }

}
