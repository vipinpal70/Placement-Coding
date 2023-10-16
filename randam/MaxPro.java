public class MaxPro {
    public static void product(int arr[]){
        int index=0,end=0; 
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int total =1 ;
            for (int j = i; j < arr.length; j++) {  
                total = total*arr[j];    
                if(total>=max){  
                    max = total; 
                    index = i;        
                    end = j;    

                }
            }
        }
        System.out.println(max);
        System.out.println(index); 
        System.out.println(end); 
    }
    public static void main(String[] args) {
        int arr[] = {2,-5,7,-3,1,-4,5,8,3};
        product(arr);
    }
}
