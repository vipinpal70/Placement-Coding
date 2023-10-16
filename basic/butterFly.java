package basic;

public class butterFly {
    public static void main(String[] args) {
        System.out.println("\n");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i <= 2 && (j <= i || j >= (7 - i))) {
                    System.out.print(" *");
                }
                if ((i != 3 && i != 4) && j > i && j < (7 - i)) {
                    System.out.print("  ");
                }
                if (i == 3 || i == 4) {
                    System.out.print(" *");
                }
                if (i >= 5 && (j <= (7 - i) || j >= i)) {
                    System.out.print(" *");
                }
                if ((i >= 5) && (j > (7 - i) && j < i)) {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
}
