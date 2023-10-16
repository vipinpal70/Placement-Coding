package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * all Important question related to searching and sorting 
 */
public class searchPls {

    // Permute two arrays such that sum of every pair is greater or equal to K
    static boolean isPossible(Integer a[], int b[], int n, int k) {
        // Sort the array a[] in decreasing order.
        Arrays.sort(a, Collections.reverseOrder());

        // Sort the array b[] in increasing order.
        Arrays.sort(b);

        // Checking condition on each index.
        for (int i = 0; i < n; i++)
            if (a[i] + b[i] < k)
                return false;

        return true;
    }

    /*
     * Find common elements in three sorted arrays
     */
    public static void commonElements(int[] a1, int[] a2, int[] a3) {
        int max = a1[0];
        int finalMax = a1[a1.length - 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        max = Math.max(max, Math.max(a2[0], a3[0]));
        for (int i = 0; i < a1.length; i++) {
            if (max <= a1[i]) {
                max = a1[i];
                break;
            }
        }
        for (int i = 0; i < a1.length; i++) {
            if (max <= a1[i]) {
                map.put(a1[i], 1);
            }
        }
        // find maximum lenght in all threes array
        int N = Math.max(a1.length, Math.max(a2.length, a3.length));

        for (int i = 0; i < N; i++) {

            if (i < a2.length && (a2[i] >= max && a2[i] <= finalMax) && map.containsKey(a2[i])) {
                map.put(a2[i], map.get(a2[i]) + 1);
            }

            if (i < a3.length && a3[i] >= max && a3[i] <= finalMax && map.containsKey(a3[i])) {
                map.put(a3[i], map.get(a3[i]) + 1);
            }
        }
        System.out.println();
        // check in map
        for (int ele : map.keySet()) {
            if (map.get(ele) == 3) {
                System.out.println(ele);
            }
        }
        System.out.println();

    }

    /*
     * Count triplets with sum smaller than a given value
     */

    public static int countTriplets(int[] arr, int sum) {
        // Sort input array
        Arrays.sort(arr);

        // Initialize result
        int ans = 0;
        int n = arr.length;

        // Every iteration of loop counts triplet with
        // first element as arr[i].
        for (int i = 0; i < n - 2; i++) {
            // Initialize other two elements as corner elements
            // of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;

                // Else move left corner
                else {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }

    /*
     * Maximum sum such that no two elements are adjacent (Stickler Thief)
     * Function to find the maximum sum
     */
    static int rec(int nums[], int idx, int N) {
        if (idx >= N)
            return 0;
        return Math.max(nums[idx] + rec(nums, idx + 2, N),
                rec(nums, idx + 1, N));
    }

    // Function to find the maximum sum
    static int findMaxSum(int[] arr, int N) {
        return rec(arr, 0, N);
    }

    /*
     * Merge two sorted arrays with O(1) extra space
     */
    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        // Iterate through all elements of ar2[] starting
        // from the last element

        for (int i = n - 1; i >= 0; i--) {
            /*
             * Find the smallest element greater than
             * ar2[i]. Move all elements one position ahead
             * till the smallest greater element is not
             * found
             */

            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j + 1] = arr1[j];

            // If there was a greater element
            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    /*
     * Count Inversions
     */
    public static int countInversion(int[] arr) {
        int ans = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            while (j < N) {
                if (arr[j] < arr[i]) {
                    ans++;
                }
                j++;
            }
        }

        return ans;
    }

    /*
     * merge sort Approach
     */
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

    /*
     * find duplicate in an array in O(n) ans constant space
     */
    public static List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int n = arr.length;

        // First check all the values that are present in
        // the array then go to those values as indices and
        // increment by the size of the array // ----> 1, 6, 3, 1, 3, 6, 6
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
            // System.out.print(arr[index] + "--" + index + " :: ");
        }
        System.out.println();
        // for (int item : arr) {
        // System.out.println(" " + item);
        // }
        System.out.println();

        // Now check which value exists more than once by
        // dividing with the size of the array
        for (int i = 0; i < n; i++) {
            if (arr[i] / n >= 2) {
                duplicates.add(i);
            }
        }
        return duplicates;
    }

    /*
     * product of array except itself
     */
    public static void productItself(int[] arr) {
        // calculate sum
        int total = 1;
        int[] pod = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            total *= arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            pod[i] = total / arr[i];
        }

        System.out.println();
        // printing production array
        for (int i = 0; i < pod.length; i++) {
            System.out.println(" " + pod[i]);
        }
        System.out.println();
    }

    /*
     * Make all array elements equal with minimum cost
     */

    public static int computeCost(int arr[], int N, int X) {
        int cost = 0;
        for (int i = 0; i < N; i++)
            cost += Math.abs(arr[i] - X);

        return cost;
    }

    public static int minCostToMakeElementEqual(int arr[], int N) {
        int low, high;
        low = high = arr[0];

        // setting limits for ternary search by
        // smallest and largest element
        for (int i = 0; i < N; i++) {
            if (low > arr[i])
                low = arr[i];
            if (high < arr[i])
                high = arr[i];
        }

        /*
         * loop until difference between low and high
         * become less than 3, because after that
         * mid1 and mid2 will start repeating
         */
        while ((high - low) > 2) {
            // mid1 and mid2 are representative array
            // equal values of search space
            int mid1 = low + (high - low) / 3;
            System.out.println("mid1--" + mid1);
            int mid2 = high - (high - low) / 3;
            System.out.println("mid2--" + mid2);

            int cost1 = computeCost(arr, N, mid1);
            int cost2 = computeCost(arr, N, mid2);
            System.out.println("cost1 : " + cost1);
            System.out.println("cost2 : " + cost2);

            // if mid2 point gives more total cost,
            // skip third part
            if (cost1 < cost2)
                high = mid2;

            // if mid1 point gives more total cost,
            // skip first part
            else
                low = mid1;
        }

        // computeCost gets optimum cost by sending
        // average of low and high as X
        return computeCost(arr, N, (low + high) / 2);
    }

    /*
     * Check if reversing a sub array make the array sorted
     */
    public static void reverse(int[] a, int x, int y) {
        while (x < y) {
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
            x++;
            y--;
        }
    }

    public static boolean sortArr(int[] a, int n) {
        int x = -1; // starting index for decreasing arr
        int y = -1; // last index of decreasing arr

        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                if (x == -1) {
                    x = i; // set start index of decreasing Array
                }
                y = i + 1; // seting last index of decreasing Array
            }
        }

        System.out.println(x);
        System.out.println(y);
        if (x != -1) {
            reverse(a, x, y);
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * findFour related to the question
     */
    public static boolean findFour(int[] arr, int i, int j, int k, int end, int value) {

        while (arr[i] + arr[j] + arr[k] + arr[end] != value && j < arr.length - 2) {
            // if (j == k-1) {
            // j += 2;
            // } else {
            // j++;
            // }
            j = (j == k - 1) ? j + 2 : j + 1;
        }
        if (arr[i] + arr[j] + arr[k] + arr[end] == value) {
            System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[end]);
            return true;
        }
        j = i + 1;
        while (arr[i] + arr[j] + arr[k] + arr[end] != value && k < arr.length - 1) {
            k++;
        }
        if (arr[i] + arr[j] + arr[k] + arr[end] == value) {
            System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[end]);
            return true;
        }
        k = j + 1;
        return false;
    }

    /*
     * Find four elements that sum to a given value (4Sum) | Set 2
     */
    public static boolean fourSum(int[] arr, int value) {
        int N = arr.length;
        Arrays.sort(arr);
        // print array after sort
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < N - 3; i++) {

            int j = i + 1, k = j + 1, end = N - 1;

            if (arr[i] + arr[j] + arr[k] + arr[end] == value) {
                System.out.println(arr[i] + "" + arr[j] + "" + arr[k] + "" + arr[end]);
                return true;

            } else if ((arr[i] + arr[j] + arr[k] + arr[end]) < value) {
                System.out.println("less");
                if (findFour(arr, i, j, k, end, value)) {
                    // System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[end]);
                    return true;
                }

            } else {
                // more than value
                System.out.println("more" + i);
                while (end > k) {
                    end--;
                    if (findFour(arr, i, j, k, end, value)) {
                        // System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[end]);
                        return true;
                    }

                }
            }
        }
        return false;
    }

    /*
     * Median of two Sorted Arrays of Different SizesMedian of two Sorted Arrays of
     * Different Sizes
     */
    public static void medianOfTwoSortedArr(int[] a, int[] b) {
        int alen = a.length;
        int blen = b.length;
        int[] mergeArray = new int[alen + blen];
        System.out.println(mergeArray.length);
        for (int i = 0; i < alen; i++) {
            mergeArray[i] = a[i];
        }
        for (int i = 0; i < blen; i++) {
            mergeArray[alen + i] = b[i];
        }
        Arrays.sort(mergeArray);
        int median = 0;
        if (mergeArray.length % 2 == 0) {
            int sum = mergeArray[mergeArray.length / 2] + mergeArray[((mergeArray.length / 2) - 1)];
            System.out.println("sum " + sum);
            median = sum / 2;
            System.out.println(median);
        } else {
            median = mergeArray[(mergeArray.length / 2)];
            System.out.println("Median : " + median);
        }

    }

    /*
     * Best Approach (binary search with divide approach)
     */

    public static double medianOfSortedArray(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2)
            return medianOfSortedArray(b, a);

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        System.out.println("left :" + left);
        int n = n1 + n2;
        while (low <= high) {
            System.out.println("low : " + low);
            int mid1 = (low + high) / 2;
            System.out.println("mid1 : " + mid1);
            int mid2 = left - mid1;
            System.out.println("mid2 : " + mid2);
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = a[mid1];
            if (mid1 < n2)
                r2 = b[mid2];

            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid1 - 1];

            System.out.println(l1 + " " + l2 + " : " + r1 + " " + r2);
            if (l1 <= r1 && l2 <= r2) {
                if (n % 2 == 1)
                    return (double) Math.max(l1, l2);
                return (double) Math.max(l1, l2) + Math.min(r1, r2) / 2.0;

            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }

    /*
     * Agressive cows (Linear Search)
     */
    public static int agressiveCows(int[] arr, int cows) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (canWePlace(arr, i, cows) == true) {
                ans = i;
            } else {
                return i - 1;
            }
        }

        return ans;
    }

    /*
     *   Agressive cows (Binary Approach)  Best Approach
     */

    public static int agressiveCowsBinaryApp(int[] arr , int cows){
        Arrays.sort(arr);
        int low = 1, high = arr[arr.length-1] - arr[0];
        while(low <= high){
            int mid = (low+high)/2;
            if(canWePlace(arr, mid, cows) == true){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return high;

    }

    public static boolean canWePlace(int[] arr, int disnt, int cows) {
        int cowCount = 1;
        int lastCows = arr[0];
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] - lastCows >= disnt) {
                cowCount++;
                lastCows = arr[j];
            }
            if (cowCount >= cows)
                return true;
        }
        return false;
    }


    /*
     * Allocate minimum number of pages
     * ----> Function to find minimum number of pages.
     */
    
    public static int findPages(int[] A, int N, int M) {

        if (N < M) {
            return -1;
        }
        int low = 0;  //max lement in the array
        int high = 0; // sum of array

        for (int i = 0; i < A.length; i++) {

            if (A[i] > low) {
                low = A[i];
            }

            high += A[i];
        }

        int res = -1;

        while (low <= high) {

            int mid = (low + high) / 2;  // it refers to pages

            if (isAllocatable(A, mid, M)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return res;
    }

    public static boolean isAllocatable(int[] A, int mid, int M) {

        int student = 1;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {

            if (sum + A[i] > mid) {
                student++;
                sum = A[i];
            } else {
                sum += A[i];
            }

        }

        return student <= M;

    }


    public static void main(String[] args) {

        // int[] arr = { 1, 100, 101 };
        // int ans = minCostToMakeElementEqual(arr, arr.length);
        // System.out.println("ans" + ans);
        // int[] arr = { 10, 2, 5, 4, 3, 7, 8, 9 };
        // System.out.println(fourSum(arr, 20));

        // int[] a = { -5, 3, 6, 12, 15 };
        // int[] b = { -12, -10, -6, -3, 4, 10 };
        // medianOfTwoSortedArr(a, b);
        // System.out.println(medianOfSortedArray(a, b));
        // int[] arr = {12,34,67,90};
        // int re = allocateMinPages(4, arr, 2);
        // System.out.println(re);

        int[] arr = { 0, 3, 4, 9, 7, 10 };
        int re = agressiveCowsBinaryApp(arr, 4);
        System.out.println(re);
    }
}
