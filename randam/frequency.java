

public class frequency {
    public static void main(String[] args) {
        int arr[] = {5,6,5,5,5,6,6,5};
        for (int i = 0; i < arr.length; i++) {
            int local=1;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    local++;
                }     
            }
            if(local > arr.length/2 ){
             System.out.println(""+arr[i]+" comes :" + local);
            }     
        }
    }
}
