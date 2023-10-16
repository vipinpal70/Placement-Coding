package divideConquer;

public class divideCon {

    // merge Sort
    public static void mergeSort(int[] arr, int start, int end) {
        // divide the array
        // base case
        if (start >= end) {
            return;
        }
        // kaam
        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid); // for left
        mergeSort(arr, mid + 1, end); // for right
        merge(arr, start, mid, end); // merge here
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // for left part
        int j = mid + 1; // for right part
        int k = 0; // for temp array index

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for left part remaining item
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for right part remaining item

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // quick Sort
    public static void quickSort(int[] arr, int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // pivot as last index
        int pIndex = partition(arr, si, ei);
        quickSort(arr, si, pIndex - 1);
        quickSort(arr, pIndex + 1, ei);

        // partition
        // i++ ---> swap(i+1 , i+2)

        // call quick sort for left part and right part

    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for els smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int tp = arr[j];  
                arr[j] = arr[i];
                arr[i] = tp;
            }
        }

        i++;
        // swap
        int tp = pivot;
        arr[ei] = arr[i];
        arr[i] = tp;

        return i;

    }

    // print array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        // mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
