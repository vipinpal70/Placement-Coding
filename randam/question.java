import java.util.Scanner;

class numcheck{
    void compareNum(int x, int y){
        int re = (x>y)? x:y;
        System.out.println("Biggest Number: "+re);
    }
}

class question{
    public static void main(String[] args) {
        numcheck ch1 = new numcheck();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ch1.compareNum(n, m);
        s.close();
    }
}