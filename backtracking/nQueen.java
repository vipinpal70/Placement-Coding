package backtracking;

public class nQueen {
    static int t = 0;

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

    public static boolean SitQeen(char[][] board, int row) { // change to boolean to check it has a solution or not
        if (row == board.length) {
            System.out.println("--------------------------------");
            // printQueen(board);  // printing the solution board
            // t++;         // counting the number of solutions

            return true;
        }

        // coloumn loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {

                board[row][j] = 'Q'; // set Q here
                if (SitQeen(board, row + 1)) // function call
                {
                    return true; // only to check it has a solution or not

                } else {
                    board[row][j] = 'x'; // backtracking
                }
            }
        }
        return false;
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }
        // SitQeen(board, 0);
        // System.out.println("\n total = " + t);
        System.out.println("It has a solution : " + SitQeen(board, 0));

    }
}
