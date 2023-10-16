/*
 * find the maximum Sub Array 
 */
public class maximumSubArr {

    static int maxSum(int[] arr) {
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length - 1; j++) {
                sum = sum + arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void kadanes(int[] numbers) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs += numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);

        }
        System.out.println("maxSubArray = " + ms);
    }

    public static void main(String[] args) {
        // int[] array = { 10, -5, 8, 4, -2, 4 - 5, 2, 1 - 5 };
        int[] array = { -2, -3, 4, -1, -2, 1, 5, -3 };
        // System.out.println(maxSum(array));
        kadanes(array);
    }
}
