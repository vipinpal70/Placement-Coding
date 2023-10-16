package basic;

public class decimalToBinary {
    public static void main(String[] args) {
        int n = 101;
        String ans = "";
        while (n > 1) {
            int re = n % 2;
            ans = re + ans;
            n = n / 2;
        }
        System.out.println(ans);
    }
}
