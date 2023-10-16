/*
 * Rotate an array horizontally
 */
public class rotateArray {

    public static void rotate(int[] arr){
        int last_el = arr[arr.length-1], i;
        for (i = arr.length-1; i > 0; i--)
            arr[i] = arr[i-1];
        arr[0] = last_el;

        for (int v : arr) {
            System.out.print(" "+v);
        }
    }

    public static void main(String[] args) {
        int [] array = {10,20,30,40,50};
        rotate(array);

    }

}
