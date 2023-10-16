import java.util.Scanner;

public class datamining {
    public static void input() {
        Scanner s = new Scanner(System.in);
        double a[] = new double[6];
        double b[] = new double[6];
        double ax = 0, bx = 0, fn = 0;

        for (int i = 0; i < 6; i++) {
            a[i] = s.nextDouble(); // x
            ax += a[i];
            b[i] = s.nextDouble(); // y
            bx += b[i];
        }
        ax = ax / 6;
        bx = bx / 6;
        fn = cov(a, b, ax, bx);
        System.out.println(fn / (Math.sqrt(ax) * (Math.sqrt(bx))));
        s.close();
    }

    public static double cov(double a[], double b[], double ax, double bx) {
        double result = 0;
        for (int i = 0; i < 6; i++) {
            result = result + (a[i] - ax) * (b[i] - bx);
        }
        return result / 5;
        
    }

    public static void main(String[] args) {
        input();
    }
}
