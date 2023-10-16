
import java.util.Calendar;

public class timezone {
    public static void main(String[] args) {
        
        Calendar rightNow = Calendar.getInstance();
        int h = rightNow.get(Calendar.HOUR_OF_DAY);
        if(h>4  && h<=11)
            System.out.println("Good Morning: ");
        else if(h>11 && h<=15)
            System.out.println("Good Afternoon: " );
        else if(h>15 && h<=19)
            System.out.println("Good Evening: " );
        else    
            System.out.println("Good Night: " );


        // System.out.println(rightNow.getTime());
        // LocalDate d1 = LocalDate.now();  
        // String d1Str = d1.format(DateTimeFormatter.ISO_DATE);  
        // System.out.println("d1Str: " + d1Str);
        
        

    }
}
 