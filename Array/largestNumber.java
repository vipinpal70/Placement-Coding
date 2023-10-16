/*
 * Find the largest element in the array
 */
public class largestNumber {
    public static int largestNum(int[] arr) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (result < arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 5, -6, 11, 9, -3, 2, -10, 4, 1 };
        System.out.println(largestNum(arr));
    }
}
