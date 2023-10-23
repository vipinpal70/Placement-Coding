package backtracking;

public class nQeenProblem {
    static int count = 0;

    public static boolean isSafe(char[][] board, int row, int col) {
        // vertical position
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left up position
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up position
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void solveNQueen(char[][] board, int row) {
        // base case
        if (row == board.length) {
            System.out.println("------------ Solution -->");
            printQueen(board);
            System.out.println();
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // seting Q
                solveNQueen(board, row + 1); // next call
                board[row][j] = 'x'; // backtracking step
            }
        }
    }

    public static void printQueen(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int N = 4;
        char[][] board = new char[N][N];

        // Initialize the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

        // function call
        System.out.println();
        solveNQueen(board, 0);
        System.out.println();
        System.out.println("Total Solution : " + count);
        System.out.println();
    }
}
