package backtracking;

/*
 * Knight’s Tour Problem backtracking question
 */

public class KnightsTourProblem {

    public static void solveKnight(int[][] board, int srow, int scol, int move) {
        // base case
        if (srow < 0 || scol < 0 || srow >= board.length || scol >= board.length || board[srow][scol] > 0) {
            return;
        } else if (move == board.length * board.length) {
            board[srow][scol] = move;
            displayBoard(board);
            // board[srow][scol] = 0;  // uncomment to see all possible moves
            return;

        }

        // recursive case
        board[srow][scol] = move;

        solveKnight(board, srow + 2, scol + 1, move + 1);
        solveKnight(board, srow + 1, scol + 2, move + 1);
        solveKnight(board, srow - 1, scol + 2, move + 1);
        solveKnight(board, srow - 2, scol + 1, move + 1);
        solveKnight(board, srow - 2, scol - 1, move + 1);
        solveKnight(board, srow - 1, scol - 2, move + 1);
        solveKnight(board, srow + 1, scol - 2, move + 1);
        solveKnight(board, srow + 2, scol - 1, move + 1);

        board[srow][scol] = 0; // backtracking step

    }

    public static void displayBoard(int[][] board) {
        System.out.println("-----------------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("    " + board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Knight's Tour Problem");
        System.out.println();
        int n = 5;
        int[][] board = new int[n][n];

        solveKnight(board, 0, 0, 1);
        System.out.println();
        System.out.println();

    }
}