package string;

import java.util.Scanner;

public class strIndroduction {
    public static void main(String[] args) {
        // char[] name = { 'v', 'i', 'p', 'i', 'n' };
        // String nn = "vipin";
        // String nm = new String("Vipin Pal");

        // using the scanner class
        Scanner s = new Scanner(System.in);
        String fullName = s.nextLine();
        System.out.println("fullName: " + fullName);

        // StringBuilder sc = new StringBuilder(fullName);

        /*
        """
                length()
                charAt()
                concat()
                equals()  
                indexOf()
                lastIndexOf()
                substring()
                substring(start, end)
                substring(start)
                compareTo()
                toLowerCase()
                toUpperCase()
                trim()
                replace()
                replaceAll()
                split()
                toCharArray()
                toCharArray(start, end)
                toCharArray(start)
                

                """
        */;
        s.close();
    }
}
