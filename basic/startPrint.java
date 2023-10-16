package basic;

public class startPrint {
    public static void main(String[] args) {
        System.out.println("");

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                if (j > i) {
                    System.out.print("  ");
                }
                if (j <= i) {
                    System.out.print("  * ");
                }
            }
            System.out.println("");
        }
         
    }
}
