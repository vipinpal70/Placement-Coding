package backtracking;

public class sudoku {

    public static boolean SolveSudoku(int[][] board, int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }

        // recursive call
        int nextRow = row;
        int nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // already placed
        if (board[row][col] != 0) {
            return SolveSudoku(board, nextRow, nextCol);
        }

        // placed digits into board
        for (int digit = 1; digit <= 9; digit++) {
            if (canWePlace(board, row, col, digit)) {
                board[row][col] = digit;
                if (SolveSudoku(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean canWePlace(int[][] grid, int curr_row, int curr_col, int val) {
        for (int i = 0; i < 9; i++) {
            if (grid[curr_row][i] == val)
                return false;
            if (grid[i][curr_col] == val)
                return false;
        }

        // grid 3x3 checking

        int sr = (curr_row / 3) * 3;
        int sc = (curr_col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // int[][] board = {
        // { 3, 6, 6, 5, 0, 8, 4, 0, 0 },
        // { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        // { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        // { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        // { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        // { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        // { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        int[][] board = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
                

        if (SolveSudoku(board, 0, 0)) {
            System.out.println("Sudoku finished");
            System.out.println();
            printGrid(board);
            System.out.println();
        } else {
            System.out.println("Answer does not exit");
        }
    }
}
