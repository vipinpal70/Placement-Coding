

public class boxSwap {

    public static void leftRotateRec(int arr[], int i, int d, int n) {
        /*
         * Return If number of elements to be rotated
         * is zero or equal to array size
         */
        if (d == 0 || d == n)
            return;

        /*
         * If number of elements to be rotated
         * is exactly half of array size
         */
        if (n - d == d) {
            swap(arr, i, n - d + i, d);
            return;
        }

        if (d < n - d) {
            swap(arr, i, n - d + i, d);
            leftRotateRec(arr, i, d, n - d);
        } else // B is shorter
        {
            swap(arr, i, d, n - d);
            leftRotateRec(arr, n - d + i, 2 * d - n, d);
            // n-d=i = i, starting index
            // 2*d-n = new d value
            // d = size of new array
        }
    }

    public static void swap(int arr[], int fi, int si, int d) {
        int i, temp;
        for (i = 0; i < d; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    public static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        int d = 2;
        int arr[] = {1,2,3,4,5,6,7};
        leftRotateRec(arr, 0, d, 7);
        printArray(arr, 7);
    }
}
