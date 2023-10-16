import java.util.Scanner;

public class singleLinkage{

    static class coordinate{
        double x , y;
        double dis =0;
    }
    

    static public double distance(coordinate a , coordinate b){
        double x2 =  Math.pow((a.x-b.x),2);
        double y2 =  Math.pow((a.y-b.y),2);
        double re =  Math.sqrt( x2+y2);
        return re;

    }

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        // double matrix[][] = new double[n][n];
        coordinate point[] = new coordinate[n];
        for (int i = 0; i < n; i++) {
            point[i] = new coordinate();
            point[i].x = s.nextDouble();
            point[i].y = s.nextDouble();   
        }

        for (int i = 0; i < n-1; i++) {
            point[i].dis = distance(point[i], point[i+1]); 
            System.out.println("");
            System.out.printf("%.3f",point[i].dis);

        }
        // for (int i = 0; i < point.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         matrix[i][j] = 
        //     }
        // }
        s.close();


    }



}