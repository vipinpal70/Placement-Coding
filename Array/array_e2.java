public class array_e2 {
    static void secondLargestElement(int[] arr){
        int first = Integer.MIN_VALUE ;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }else if(arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }
        System.out.println("Second Largest Elements : "+second);
    }
    public static void main(String[] args) {
        int arr[] = { 12, 13, 1, 10, 34, 1 };
        secondLargestElement(arr);
    }

}
