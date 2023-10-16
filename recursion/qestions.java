package recursion;

public class qestions {

    // print number n to 1 using recurtion funtion
    public static void num(int n) {
        // base case
        if (n == 0) {
            return;
        }

        // function work
        System.out.print(" " + n);

        // recurtion inner call
        num(n - 1);
    }

    // factorial using recurtion methaod
    public static int factorial(int n) {
        // base care
        if (n == 1)
            return 1;

        // function work & inner call
        int fact = n * factorial(n - 1);

        return fact;
    }

    // print sum of first n natural numbers

    public static int firstNsum(int n) {
        // base case
        if (n == 1)
            return 1;

        // function work & inner call
        int ans = n + firstNsum(n - 1);

        return ans;
    }

    // fibonacci Number using recursion method;
    public static int fibonacci(int n) {
        // base case
        if (n == 0 || n == 1)
            return n;

        // function work & inner call

        int a = fibonacci(n - 1);
        int b = fibonacci(n - 2);
        int ans = a + b;

        return ans;

    }

    // check if a given array is sorted or not
    public static boolean isSorted(int[] arr, int i) {
        // base case
        if (i == arr.length - 1)
            return true;

        // function work
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        // inner call & return
        return isSorted(arr, i + 1);

    }

    public static int fisrtOccurance(int[] arr, int index, int key) {
        // base case
        if (index == arr.length)
            return -1;

        // function work
        if (key == arr[index]) {
            return index;
        }
        // inner call
        return fisrtOccurance(arr, index + 1, key);

    }

    public static int lastOccurance(int[] arr, int index, int key) {
        // base case
        if (index == -1)
            return -1;

        // function work
        if (key == arr[index]) {
            return index;
        }
        // inner call
        return fisrtOccurance(arr, index - 1, key);

    }

    public static int powerOfn(int num, int power) {
        // base case
        // if (power == 0)
        // return 1;

        // function work
        // int ans = num * powerOfn(num, power - 1);

        // return ans;

        // ============ Best Approach O(log n ) ===============>

        // base case
        if (power == 1)
            return num;

        // function work
        int halfPower = powerOfn(num, power / 2);
        int ans = halfPower * halfPower;

        if (power % 2 != 0) {
            ans = num * ans;
        }

        return ans;
    }

    // Tiling Problem floor size 2*n ans tile size 2*1
    public static int totalwaysOfTile(int n) {
        // base case
        if (n == 0 || n == 1)
            return 1;

        // function work ---->

        // vertical way f(n-1)
        int vertical = totalwaysOfTile(n - 1);

        // horizontal way f(n-2)
        int horizontal = totalwaysOfTile(n - 2);

        return vertical + horizontal;
    }

    // remove duplicates character in a string
    public static void removeDuplicate(String str, int index, StringBuilder newString, boolean map[]) {
        // base case
        if (index == str.length()) {
            System.out.println(newString);
            return;
        }

        if (map[str.charAt(index) - 'a']) {
            removeDuplicate(str, index + 1, newString, map);
        } else {
            map[str.charAt(index) - 'a'] = true;
            removeDuplicate(str, index + 1, newString.append(str.charAt(index)), map);
        }

    }

    public static int friendsPair(int n) {
        // base case
        if (n == 2 || n == 1) {
            return n;
        }
        // kaam
        // // single
        // int single = friendsPair(n - 1);

        // // pair
        // int pair = (n-1) * friendsPair(n - 2);

        // return single + pair;

        return friendsPair(n - 1) + (n - 1) * friendsPair(n - 2);
    }

    // Binary String Problem ----> without consecutive ones
    public static void binaryString(String str, int lastPlaced, int n) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // kaam
        binaryString(str + "0", 0, n - 1);

        if (lastPlaced == 0) {
            // sit 0 on chair n
            binaryString(str + "1", 1, n - 1);

        }
    }

    public static void main(String[] args) {
        // num(5);
        // System.out.println(factorial(5));
        // System.out.println(firstNsum(10));
        // System.out.println(fibonacci(26));

        // int[] arr = { 0, 1, 2, 3, 4, 5 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(fisrtOccurance(arr, 0, 5));

        // int[] arr = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        // System.out.println(lastOccurance(arr, arr.length - 1, 5));

        // System.out.println(powerOfn(2, 10));
        // System.out.println(totalwaysOfTile(3));
        // String str = "appnnacollege";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendsPair(3));
        binaryString("", 0, 3);

    }
}
