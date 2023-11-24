package Greedy;

// Java program to find minimum
// number of squares to cut a paper.
public class PaperCut {

    // To swap two numbers
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // Returns min number of squares needed
    static int minimumSquare(int a, int b) {
        int result = 0, rem = 0;

        // swap if a is small size side .
        if (a < b)
            swap(a, b);

        // Iterate until small size side is
        // greater than 0
        System.out.println(a + " " + b);
        while (b > 0) {
            // Update result
            result += a / b;
            rem = a % b;
            a = b;
            b = rem;
        }

        return result;
    }

    public static void paperMin(int a, int b) {
        int ans = 0;

        while (a != 0 && b != 0) {
            if (a < b) {
                b = b - a;
                ans++;
                System.out.println("ans = "+ans);
            } else {
                a = a - b;
                ans++;
            }
        }
        System.out.println();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int n = 13, m = 29;
        System.out.println(minimumSquare(n, m));
        paperMin(n, m);
    }
}
