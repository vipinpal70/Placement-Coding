package backtracking;

/*
 * Longest Possible Route in a Matrix with Hurdles
 */
public class LongestPossibleRoute {
    public static int findLongestPath(int[][] mat, int i, int j, int di, int dj, int n, int m, int cur, int ans) {
        // If we reach the destination
        if (i == di && j == dj) {
            // If current path steps are more than previous
            // path steps
            if (cur > ans)
                ans = cur;
            return ans;
        }

        // if the source or destination is a hurdle itself
        if (mat[i][j] == 0 || mat[di][dj] == 0)
            return ans;

        // Mark as visited
        mat[i][j] = 0;

        // Checking if we can reach the destination going
        // right
        if (j != m - 1 && mat[i][j + 1] > 0)
            ans = findLongestPath(mat, i, j + 1, di, dj, n,
                    m, cur + 1, ans);

        // Checking if we can reach the destination going
        // down
        if (i != n - 1 && mat[i + 1][j] > 0)
            ans = findLongestPath(mat, i + 1, j, di, dj, n,
                    m, cur + 1, ans);

        // Checking if we can reach the destination going
        // left
        if (j != 0 && mat[i][j - 1] > 0)
            ans = findLongestPath(mat, i, j - 1, di, dj, n,
                    m, cur + 1, ans);

        // Checking if we can reach the destination going up
        if (i != 0 && mat[i - 1][j] > 0)
            ans = findLongestPath(mat, i - 1, j, di, dj, n,
                    m, cur + 1, ans);

        // Marking visited to backtrack
        mat[i][j] = 1;

        // Returning the answer we got so far
        return ans;

    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        // find longest path with source (0, 0) and
        // destination (1, 7)
        int ans = findLongestPath(mat, 0, 0, 1, 7, 3, 10, 0, 0);
        System.out.println("Ans " + ans);
    }
}
