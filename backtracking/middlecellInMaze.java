package backtracking;

import java.util.ArrayList;
import java.util.List;

class Pair {
    int x = 0;
    int y = 0;

    Pair(int row, int col) {
        x = row;
        y = col;
    }
}

public class middlecellInMaze {
    public static boolean inBoundry(int[][] maze, int row, int col) {
        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length) {
            return true;
        }
        return false;
    }

    public static boolean isSafe(int[][] maze, int row, int col) {
        if (maze[row][col] != 0 && maze[row][col] != -1) {
            return true;
        }
        return false;
    }

    public static void printlist(List<Pair> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("--> ("+ list.get(i).x + "," + list.get(i).y +") ");
        }
        System.out.print("====> Mid");
    }

    public static void cornerToMid(int[][] maze, int sr, int sc, List<Pair> list) {
        // base case
        if (!inBoundry(maze, sr, sc)) {
            return;
        }

        if (sr == maze.length / 2 && sc == maze[0].length / 2) {
            list.add(new Pair(sr, sc));
            System.out.println();
            printlist(list);
            System.out.println();
            System.out.println();
            return;
        }


        // recursive step
        if (isSafe(maze, sr, sc)) {
            int n = maze[sr][sc];
            maze[sr][sc] = -1;
            list.add(new Pair(sr, sc));
            cornerToMid(maze, sr, sc + n, list);
            cornerToMid(maze, sr + n, sc, list);
            cornerToMid(maze, sr, sc - n, list);
            cornerToMid(maze, sr - n, sc, list);
            maze[sr][sc] = n;
            list.remove(list.size() - 1);
        } else {
            return;
        }

    }

    public static void main(String[] args) {
        int[][] maze = {
                { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
                { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
                { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
                { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
                { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
                { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
                { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
                { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
                { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

        List<Pair> list = new ArrayList<Pair>();

        cornerToMid(maze, 0, 0, list);
    }
}
