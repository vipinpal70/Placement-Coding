package StacksQueue;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y, z;

    Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class MinDistHav1 {

    // Function to find distance of nearest 1 in the grid for each cell.
    public static int[][] nearest(int[][] grid) {
        // Code here
        int vis[][] = new int[grid.length][grid[0].length];
        int dist[][] = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            dist[pair.x][pair.y] = pair.z;
            for (int k = 0; k < 4; k++) {
                int nx = pair.x + dx[k];
                int ny = pair.y + dy[k];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && vis[nx][ny] == 0) {
                    vis[nx][ny] = 1;
                    q.add(new Pair(nx, ny, pair.z + 1));
                    // System.out.println(nx+" "+ny+" "+ (pair.z + 1)); 
                }
            }
        }
        return dist;

    }

    public static void main(String[] args) {
        // int[][] mat = {{ 0, 1, 1, 0 },{ 1, 1, 0, 0 },{ 0, 0, 1, 1 } };
        int[][] mat = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };

        int[][] ans = new int[mat.length][mat[0].length];

        ans = nearest(mat);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(" " + ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}