public class Eui {
    
    public static void check (int arr[] , int sum){
        int a = 0 ;
        for (int i = 0; i < arr.length; i++) {
            a += arr[i];     
            if(a == sum ){     
                System.out.println("index: "+i);   
                System.out.println("SUM: "+sum);   
            }  
            sum = sum - arr[i];       
        }
    }
    public static void main(String[] args) {
        int arr[] = {-2,5,3,1,2,6,-4,2};  
        check(arr, 13);
    }
}

