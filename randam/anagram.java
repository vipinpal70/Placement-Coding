import java.util.Scanner;

class anagram{
    static void change(int arr[]){
        for(int i= 0; i<arr.length;i++){
            if(arr[i] != arr[arr.length-1]){
                //int temp ; 
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int arr[] = new int[5];
        int size = 5;
        while(size >0){
            arr[size-1] = s.nextInt();
            size--;
        }
        change(arr);
        s.close();

    }
}