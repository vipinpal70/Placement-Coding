import java.util.Arrays;

public class array_e10 {

    static void countTriangle(int[] arr) {

        Arrays.sort(arr);
        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k])
                        count++;
                }

            }

        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] input = { 4, 6, 3, 7 };
        countTriangle(input);
    }
}
