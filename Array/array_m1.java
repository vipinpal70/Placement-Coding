/*
 * Rearrange an array such that arr[i] = i
 */
public class array_m1 {

    static void rearrangeArr(int[] arr) {
        int res[] = new int[arr.length];

        for (int i = 0; i < res.length; i++) {
            if (search(arr, i)) {
                res[i] = i;
            } else {
                res[i] = -1;
            }
        }
        for (int i : res) {
            System.out.print(" " + i);
        }
    }

    static boolean search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        rearrangeArr(arr);

    }
}
