public class trappingWater {
    public static void tapWater(int[] arr) {
        int totalWater = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i != arr.length - 1) {
                int leftSide = largest(arr, 0, i);
                int rightSide = largest(arr, i, arr.length);
                if (leftSide > arr[i] && rightSide > arr[i]) {
                    int tp = Math.min(leftSide, rightSide);
                    totalWater += (tp - arr[i]);
                }
            }
        } 
        
        System.out.println("");
        System.out.println(totalWater);
    }

    public static int largest(int[] arr, int start, int last) {
        int result = Integer.MIN_VALUE;
        for (int i = start; i < last; i++) {
            if (result < arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 6, 3, 2, 5 };
        tapWater(height);
    }
}
