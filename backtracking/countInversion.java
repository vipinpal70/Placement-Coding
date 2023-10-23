package backtracking;

public class countInversion {
    public static long countInversionUsingMerge(int[] arr) {
        int N = arr.length;

        return mergeSort(arr, 0, (int) N - 1);
    }

    private static long mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;
            long l1 = mergeSort(arr, l, mid);
            long l2 = mergeSort(arr, mid + 1, h);
            long l3 = merge(arr, l, mid, h);
            // System.out.println("l1: "+l1+", l2: "+l2+", l3: "+l3);
            return (l1 + l2 + l3);
        } else
            return 0;
    }

    private static long merge(int[] arr, int l, int mid, int h) {
        long[] b = new long[h - l + 1];
        int i = l, j = mid + 1, k = 0;
        long count = 0;

        while (i <= mid && j <= h) {
            if (arr[i] > arr[j]) {
                b[k++] = arr[j++];
                count += (mid - i + 1);
            } else {
                b[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            b[k++] = arr[i++];
        }

        while (j <= h) {
            b[k++] = arr[j++];
        }

        int t = l;
        for (k = 0; k < b.length; k++) {
            arr[t++] = (int) b[k];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 8, 2, 6, 4 };
        System.out.println(countInversionUsingMerge(arr));
    }
}
