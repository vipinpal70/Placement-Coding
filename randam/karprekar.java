import java.util.Scanner;

public class karprekar {
    public static int newNumber(int num , int d){
        int c = 1, m = 0;
        if(d%2==0){
            while(num>0){
                if(c == d/2 || c==(d/2)+1 ){
                    m += num%10; 
                }
                num = num/10;
                c++;
                // 123456    --->     7  
            }
            return m;
        }else{
            while(num>0){
                if(c==(d/2)+1 ){
                    m = num%10; 
                }
                num = num/10;
                c++;
                 
            }
            return m;
        }

    }
    public static int digits(int num){
        int  t = 0;
        while(num>0){
            num = num/10;
            t++;
        }
        return t;
    }
    public static void check(int nm){
        if(nm%3==0){
            System.out.println("karprekar number");
        }
        else if(nm ==0){
            System.out.println("Not");
        }
        else{
            System.out.println("Not");
        }
    }
    public static void perform(int nm){
       int sq = nm*nm;
       int t = digits(sq);
       if(t == 3){
           String numb = String.valueOf(sq);
           String ft,sc;
           ft = numb.substring(0,2);
           sc = numb.substring(2,3);
           int scr = Integer.parseInt(ft)+Integer.parseInt(sc);
           
           if(nm == scr){
            System.out.println("karprekar number");
           }
           else{
            System.out.println("Not");
           }

       }
       if(t == 4){
           String numb = String.valueOf(sq);
           String ft,sc;
           ft = numb.substring(0,2);
           sc = numb.substring(2,4);
           int scr = Integer.parseInt(ft)+Integer.parseInt(sc);
           

           if(nm == scr){
            System.out.println("karprekar number");
           }
           else{
            System.out.println("Not");
           }

       }
       if(t == 5){
           String numb = String.valueOf(sq);
           String ft,sc;
           ft = numb.substring(0,2);
           sc = numb.substring(2,4);
           int scr = Integer.parseInt(ft)+Integer.parseInt(sc);
          
           if(nm == scr){
            System.out.println("karprekar number");
           }
           else{
            System.out.println("Not");
           }

       }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        if(number>99){
            int t = digits(number);
            int nm = newNumber(number, t);
            check(nm);
            }
             
        if(number>10 && number <=99)
        {
             perform(number);
        }
        s.close();
    }

}
