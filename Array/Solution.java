class Solution {
    public static int solution(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        for (int i = 1; i < N - 1; i++) {
            B[i] = A[i];
            for (int j = i + 2; j < N - 1; j++) {
                B[i] = Math.min(B[i], A[i] + A[j]);
            }
        }
        int min_cost = Integer.MAX_VALUE;
        for (int i = 1; i < N - 2; i++) {
            min_cost = Math.min(min_cost, B[i] + B[i + 1]);
        }
        return min_cost;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 4, 6, 3, 7 };
        System.out.println(solution(arr));
    }
}
