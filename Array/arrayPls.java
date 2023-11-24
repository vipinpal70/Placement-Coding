
/*
 * Top level Array Problem that comes in coding Exams and Interviews.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class arrayPls {

    /*
     * for MIN And MAX element in array
     */
    public static void minMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE; // ---
        int min = Integer.MAX_VALUE; // ++
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println(max + " : " + min);
    }

    /*
     * for Reverse Array
     */
    public static void reverseArray(int[] arr) {
        int st = 0, last = arr.length - 1;
        while (st < last) {
            int tp = arr[st];
            arr[st] = arr[last];
            arr[last] = tp;
            st++;
            last--;
        }
        for (int i : arr) {
            System.out.print(" : " + i);
        }
    }

    /*
     * maximum-sub use Kadane's Algorithm
     */
    public static int maxsumKadane(int[] arr) {
        int cr = 0, tl = 0;
        for (int i = 0; i < arr.length; i++) {
            cr += arr[i];
            if (cr > 0) {
                tl = Math.max(cr, tl);
            } else {
                cr = 0;
                tl = 0;
            }
        }
        return tl;

    }

    /*
     * checking Duplicate Element
     */
    public static boolean checkDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                // System.out.println("Duplicate Fount !");
                return true;
            }
        }
        return false;
    }

    /*
     * for Chocolate Distribution Problem
     */
    public static void chocolateDistribution(int[] arr, int st) {
        int sum = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - st; i++) {
            int local = arr[i + st] - arr[i];
            sum = Math.min(sum, local);
        }
        System.out.println(sum);
    }

    /*
     * Search in Rotated Sorted Array leetcode no 33
     * 
     * Best Approach
     */

    public static int searchInRotatedSorted(int[] arr, int target) {
        int N = arr.length, LOW = 0, HIGH = N - 1;
        while (LOW <= HIGH) {

            int mid = LOW + (HIGH - LOW) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[LOW] <= arr[mid]) {
                if (target >= arr[LOW] && target < arr[mid]) {
                    HIGH = mid - 1;
                } else {
                    LOW = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[HIGH]) {
                    LOW = mid + 1;
                } else {
                    HIGH = mid - 1;
                }
            }
        }
        return -1;
    }

    /*
     * Simple Binary Search Approach
     */

    public static int searchInRotatedSorted2(int[] arr, int target) {
        int N = arr.length, LOW = 0, HIGH = N - 1;
        while (LOW <= HIGH) {
            int mid = LOW + (HIGH - LOW) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target >= arr[LOW] && target < arr[mid]) {
                HIGH = mid - 1;
            } else {
                LOW = mid + 1;
            }
        }
        return -1;

    }

    /*
     * Next Permutation leetcode 31
     */

    public static void nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
            reverse(arr, i + 1, arr.length - 1);
        }
        for (int k : arr) {
            System.out.print(" " + k);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    /*
     * leetcode 121
     */
    public static void buySell(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int maxProfitIndex = 0;
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            int in = largest(prices, i);
            if (prices[i] >= prices[in]) {
                profit[i] = 0;
            } else {
                profit[i] = largest(prices, i);
            }
            if (profit[i] != 0) {
                int pr = prices[profit[i]] - prices[i];
                if (pr > maxProfit) {
                    maxProfit = pr;
                    maxProfitIndex = i;
                }
                // System.out.print(" : " + pr);
            }

        }
        // for (int i : profit) {
        // System.out.print(" " + i);
        // }
        System.out.println("Buying Price  " + prices[maxProfitIndex] + " at the " + maxProfitIndex + " Day");
        System.out.println(
                "Selling Price  " + prices[profit[maxProfitIndex]] + " at the " + profit[maxProfitIndex] + " Day");
        System.out.println("Total Profit Per Share : " + (prices[profit[maxProfitIndex]] - prices[maxProfitIndex]));
    }

    public static int largest(int[] arr, int start) {
        int result = Integer.MIN_VALUE;
        int index = 0;
        for (int i = start; i < arr.length; i++) {
            if (result < arr[i]) {
                result = arr[i];
                index = i;
            }
        }
        return index;
    }

    /*
     * Repeat and Missing Number Array
     */
    public static void repeatNumber(int[] arr) {
        int reapt = 0, miss = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                reapt = arr[i];
                miss = arr[i] + 1;
            }

        }
        System.out.println("Reapt Num : " + reapt);
        System.out.println("Missing Num : " + miss);
    }

    /*
     * Kth Largest Element in an Array
     * leetcode 215
     */
    public static int kThLargestElement(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    /*
     * Trapping Rain Water
     */

    public static void tapWater(int[] arr) {
        int totalWater = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i != arr.length - 1) {
                int leftSide = largest(arr, 0, i);
                int rightSide = largest(arr, i, arr.length);
                if (leftSide > arr[i] && rightSide > arr[i]) {
                    int tp = Math.min(leftSide, rightSide);
                    totalWater += (tp - arr[i]);
                }
            }
        }

        System.out.println("");
        System.out.println(totalWater);
    }

    public static int largest(int[] arr, int start, int last) {
        int result = Integer.MIN_VALUE;
        for (int i = start; i < last; i++) {
            if (result < arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    /*
     * Product of Array Except Self 238
     */
    public static int[] productOfArrayExceptSelf(int[] arr) {
        int[] result = new int[arr.length];
        int total = 1;
        for (int i = 0; i < arr.length; i++) {
            total = total * arr[i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = total / arr[i];
        }
        return result;
    }

    /*
     * leetcode 152
     * Maximum Product Subarray
     */
    public static int maximumProductSubarray(int[] arr) {
        int ans = arr[0];
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int tp = max;
                max = min;
                min = tp;
            }
            max = Math.max(arr[i], ans * arr[i]);
            min = Math.min(arr[i], ans * arr[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
    /*
     * leetcode 153
     * Find Minimum in Rotated Sorted Array
     */

    public static int minInRotatedSortedArray(int[] arr) {
        int N = arr.length;
        int low = 0, high = N - 1, min = Integer.MAX_VALUE;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            min = Math.min(min, arr[mid]);
            if (arr[low] < arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[high] < min) {
                    min = arr[mid];
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return min;
    }

    /*
     * Find if there is a pair with a given sum in the rotated sorted Array
     */
    public static boolean pairSum(int[] arr, int x) {
        Arrays.sort(arr);
        int N = arr.length;
        int low = 0, high = N - 1;
        while (low < high) {
            if (x == (arr[low] + arr[high])) {

                return true;
            }
            if (x < (arr[low] + arr[high])) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }

    /*
     * leetcode 15 3Sum
     */
    public static boolean threeSum(int[] arr) {
        int[] local = arr;
        Arrays.sort(local);
        for (int i = 0; i < arr.length - 3; i++) {
            int low = i, high = arr.length - 1;
            int tsum = local[i];
            while (low < high) {
                if (tsum + (local[low] + local[high]) == 0) {
                    return true;
                }
                if (tsum + (local[low] + local[high]) > 0) {
                    high--;
                } else {
                    low++;
                }
            }

        }
        return false;

    }
    /*
     * leetcode 11
     * Container With Most Water
     */

    public static int containerWithMostWater(int[] height) {
        int total = 0, start = 0, end = height.length - 1;
        int water;
        while (start < end) {
            water = (end - start) * Math.min(height[start], height[end]);
            if (water > total) {
                total = water;
            }
            if ((Math.min(height[start], height[end]) == height[start])) {
                start++;
            } else {
                end--;
            }
        }
        return total;
    }

    // Merge Overlapping Intervals
    /**
     * InnerarrayPls
     */
    static class Interval {
        int start = 0;
        int end = 0;

        Interval(int x, int y) {
            this.start = x;
            this.end = y;
        }

    }

    // Incomplete function ------------------------------------------------------
    public static void mergeOverlappingIntervals(Interval[] point) {

        int N = point.length;

        if (N <= 0) {
            return;
        }

        Stack<Interval> stack = new Stack<>();
        // Arrays.sort(point,new Comparator<Integer>(){
        // public int compare(Interval i1 , Interval i2) {
        // return i1.start - i2.start;
        // }
        // });

        stack.push(point[0]);
    }
    /*
     * merge Operations To Make An Array Palindrom
     */

    public static int mergeOperationsToMakeAnArrayPalindrome(int[] arr) {
        int count = 0;
        for (int i = 0, j = arr.length - 1; i <= j;) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                j--;
                arr[j] = arr[j + 1];
                count++;
            } else {
                i++;
                arr[i] = arr[i - 1];
                count++;
            }
        }
        return count;
    }
    /*
     * biggest Number as a string in an array
     */
    public static void biggestNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String ij = "";
            String ji = "";
            for (int j = i + 1; j < arr.length; j++) {
                ij = "" + arr[i] + "" + arr[j];
                ji = "" + arr[j] + "" + arr[i];
                if (Integer.parseInt(ji) > Integer.parseInt(ij)) {
                    swap(arr, i, j);
                }

            }
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }
    /*
     * space Optimasation 
     */
    public static void spaceOptimasation(int start, int end) {
        int s = Math.abs(end - start) + 1;
        int[] arr = new int[s];
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                arr[i - start] = 1;
            }
        }
        System.out.println("");

        for (int i = start; i <= end; i++) {
            if (arr[i - start] == 1) {
                System.out.print(i + " ");

            }
        }
    }
    /*
     * longestSubArrayWithDivisibleByK
     */
    public static int longestSubArrayWithDivisibleByK(int[] arr, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rm = sum % k;

            if (rm < 0)
                rm = rm + k;

            if (map.containsKey(rm)) {
                int idx = map.get(rm);
                int ln = i - idx;
                if (ln > ans)
                    ans = ln;

            } else {
                map.put(rm, i);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = { 10, 20, 30, 35, 40, 21, 35 };
        // minMaxElement(arr);
        // reverseArray(arr);
        // special case for only maxsum
        // int[] arr = { 1, -5, 7, -2, 6, 5, 8, -1 };
        // System.out.println(maxsumKadane(arr));
        // System.out.println("cDuplicate Found : " + checkDuplicate(arr));
        // int[] chocolate = { 7, 3, 2, 4, 9, 12, 56 };
        // int[] chocolate = { 3, 4, 1, 9, 56, 7, 9, 12 };
        // chocolateDistribution(chocolate, 4);
        // int[] arr = { 0, 1, 2, 4, 5, 6, 7 };
        // int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        // System.out.println(" : " + searchInRotatedSorted(arr, 0));
        // int[] arr = { 7, 2, 5, 3, 1 };
        // nextPermutation(arr);
        // int[] arr = { 1, -2, 3, 4 };
        // repeatNumber(arr);
        // System.out.println(kThLargestElement(arr, 3));
        // int[] re = productOfArrayExceptSelf(arr);
        // for (int i : re) {
        // System.out.print(" : " + i);
        // }
        // System.out.println(maximumProductSubarray(arr));
        // int[] arr = { -4, 5, 6, 7, 1, -2 };
        // int[] arr = { 11, 13, 15, 17 };
        // System.out.println(minInRotatedSortedArray(arr));
        // System.out.println(pairSum(arr, 14));
        // int[] arr = { -1, 0, 1, 2, -1, -4 };
        // int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int[] arr = { 1, 1 };
        // System.out.println(containerWithMostWater(arr));

        // // only for Merge Overlapping Intervals Question
        // //
        // // arrayPls.Interval arr[] = new arrayPls.Interval[4];
        // // arr[0] = new Interval(6, 8);
        // // arr[1] = new Interval(1, 9);
        // // arr[2] = new Interval(2, 4);
        // // arr[3] = new Interval(4, 7);

        // int arr[] = { 1, 4, 5, 9, 8, 1 };
        // System.out.println(mergeOperationsToMakeAnArrayPalindrome(arr));

        // int[] arr = { 54, 546, 548, 60 };
        // biggestNumber(arr);

        // spaceOptimasation(2, 10);
        int[] arr = { 2, 7, 6, 1, 4, 5 };
        int result = longestSubArrayWithDivisibleByK(arr, 3);
        System.out.println("result: " + result);
    }
}
