import java.util.Scanner;

class cong {
    

    static int func(int z1 , int Z1 ,int a1){
        for(int i = 1 ; i<100;i++){ 
            if(a1 == (Z1*i)/z1 ){
                return i;
            
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a1,m1,a2,m2,a3,m3 ;
        a1 = s.nextInt();
        m1 = s.nextInt();
        a2 = s.nextInt();
        m2 = s.nextInt();
        a3 = s.nextInt();
        m3 = s.nextInt();

        int M = m1*m2*m3;

        int M1 = M / m1;
        int M2 = M / m2;
        int M3 = M / m3;
    int re = func(m1,M1,a1);
    int re2= func(m2,M2,a2);
    int re3= func(m3,M3,a3);
    System.out.println(re);
    System.out.println(re2);
    System.out.println(re3);
    s.close();
      
    } 

}
