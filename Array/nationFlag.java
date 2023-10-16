/*
 * Dutch National Flag problem
 */

public class nationFlag {

    static void swap(int[] array , int l , int m){
        int temp = array[l];
        array[l] = array[m];
        array[m] = temp;
    }
     
    static void sort(int[] a){
        int lo = 0;
        int mid = 0;
        int hi = a.length-1;
        int temp;
        while(mid <= hi){
            switch (a[mid]) {
                
                    // If the element is 0
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                    // If the element is 1
                case 1:
                    mid++;
                    break;
                    // If the element is 2
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
        // for printing the array values
        for (int i : a) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,1,0,2,0,1};
        sort(arr);
    }

}
