package backtracking;

/*
 * Decision , Optimization, Enumeration(total path)
 * 
 */
public class backtrak {

    public static void arrayTrack(int arr[], int index, int value) {
        // base case
        if (index == arr.length) {
            printArray(arr);
            return;
        }
        // kaam
        arr[index] = value;
        arrayTrack(arr, index + 1, value + 1);
        // backtraking step
        arr[index] = arr[index] - 2;

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println("");
    }

    // find & print all subset of a given string
    public static void subSet(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {

                System.out.println(ans);
            }
            return;
        }

        // kaam recurtion
        // yes choise
        subSet(str, ans + str.charAt(i), i + 1);

        // no choise
        subSet(str, ans, i + 1);

    }

    // find permutations of string
    public static void strPermutations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // kaam recurtion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            //remove curr character from string
            String newstr = str.substring(0, i) + str.substring(i + 1);
            strPermutations(newstr, ans + curr);
        }

    }

    public static void main(String[] args) {

        // int[] arr = new int[5];
        // arrayTrack(arr, 0, 1);
        // printArray(arr);
        String stri = "abc";
        // subSet(stri, "", 0);
        strPermutations(stri, "");

    }
}
