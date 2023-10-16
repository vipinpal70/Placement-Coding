public class subArray extends largestNumber {
    public static void sArray(int[] arr) {
        int max = Integer.MIN_VALUE, min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    // System.out.print(" " + arr[k]);
                    sum += arr[k];
                }
                // System.out.println(" sum = " + sum);
                if (max < sum) {
                    max = sum;
                }
                if (min > sum) {
                    min = sum;
                }
                // System.out.println("");
            }
            // System.out.println("");
        }
        System.out.println("MAX = " + max);
        System.out.println("MIN = " + min);
    }

    public static int minimumNum(int[] arr) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int[] arr = { 1, -2, 6, -1, 3 };
        int[] arr = { 2, 4, 6, 8, 10 };
        sArray(arr);

    }
}
