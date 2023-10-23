package backtracking;

/*
 * Rat in a Maze problem
 */
public class RatInMaze {

    public static boolean isSafe(int[][] maze, int row, int col, int[][] sol) {
        return (row >= 0 && col >= 0 && row < maze.length && col < maze.length && maze[row][col] == 1
                && sol[row][col] != 1);
    }

    public static void solveMaze(int[][] maze, int sr, int sc, int[][] sol) {

        // base case
        if (sr == maze.length - 1 && sc == maze.length - 1 && maze[sr][sc] == 1) {
            sol[sr][sc] = 1;
            printmaze(sol);
            System.out.println();
            return;
        } else if (sr == maze.length - 1 && sc == maze.length - 1 && maze[sr][sc] != 1) {
            System.out.println("Solution doe's not Exit");
            return;
        }

        if (isSafe(maze, sr, sc, sol)) {
            sol[sr][sc] = 1;
            solveMaze(maze, sr, sc + 1, sol);
            solveMaze(maze, sr + 1, sc, sol);
            solveMaze(maze, sr, sc - 1, sol);
            solveMaze(maze, sr - 1, sc, sol);
            maze[sr][sc] = 2;
        } else {

            return;
        }

    }

    public static void printmaze(int[][] maze) {
        System.out.println();
        System.out.println("------ Ans ---------");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {

                System.out.print("  " + maze[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        // int[][] maze = new int[n][n];

        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int[][] sol = new int[n][n];
        solveMaze(maze, 0, 0, sol);
        System.out.println();
        System.out.println();
        // printmaze(maze);
        System.out.println();
        System.out.println();
    }
}
