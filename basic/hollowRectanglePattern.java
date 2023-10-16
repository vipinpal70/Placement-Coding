package basic;

public class hollowRectanglePattern {
    public static void main(String[] args) {
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    System.out.print(" *");
                } else if (i != 4 && (j > 0 && j < 4)) {
                    System.out.print("  ");
                } else if (i != 4 && (j == 0 || j == 4)) {
                    System.out.print(" *");
                } else if (i == 4) {
                    System.out.print(" *");
                }
            }
            System.out.println("");
        }
    }
}
