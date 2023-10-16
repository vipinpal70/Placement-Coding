// import java.util.*;
class reverseArray{

    public static void reverseArr(int[] arr){
        int start =  0;
        int last = arr.length-1;
        while(start <= last){
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;
            start++;
            last--;
        }
        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        reverseArr(array);
    }
}

