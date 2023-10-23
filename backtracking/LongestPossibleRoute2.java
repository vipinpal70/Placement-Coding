package backtracking;

public class LongestPossibleRoute2 {
    public static int findLongestPath(int[][] mat, int sr, int sc, int dr, int dc, int cur, int total) {
        // base case
        if (mat[sr][sc] == 0 || mat[dr][dc] == 0)
            return -1;

        if (sr == dr && sc == dc) {
            if (cur > total) {
                total = cur;
            }
            return total;
        }

        // Mark as visited
        mat[sr][sc] = 5;

        // Checking if we can reach the destination going
        // right
        if (sc != mat[0].length - 1 && mat[sr][sc + 1] == 1)
            total = findLongestPath(mat, sr, sc + 1, dr, dc, cur + 1, total);

        // Checking if we can reach the destination going
        // down
        if (sr != mat.length - 1 && mat[sr + 1][sc] == 1)
            total = findLongestPath(mat, sr + 1, sc, dr, dc, cur + 1, total);

        // Checking if we can reach the destination going
        // left
        if (sc != 0 && mat[sr][sc - 1] == 1)
            total =  findLongestPath(mat, sr, sc - 1, dr, dc, cur + 1, total);

        // Checking if we can reach the destination going up
        if (sr != 0 && mat[sr - 1][sc] == 1)
            total = findLongestPath(mat, sr - 1, sc, dr, dc, cur + 1, total);

        mat[sr][sc] = 1;

        return total;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        int re = findLongestPath(mat, 0, 0, 1, 7, 0, 0);
        System.out.println("Total ways : "+re);
    }
}
