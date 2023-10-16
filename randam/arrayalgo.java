import java.util.Scanner;

public class arrayalgo {

    static int fun(int arr[][] , int r , int c){
        int max = 0;
        for (int i = 0; i < r-2; i++) {
            int sum = 0; 
            for (int j = 0; j <  c-2; j++) {
                sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                if(max<sum){
                    max = sum;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[][]  = new int[4][4];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <  4; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(" max: " + fun(arr,4,4)); 
        s.close();     
    }
}
