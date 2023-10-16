package backtracking;

public class nQueen {
    static int t = 0;

    public static void Sitqeen(char[][] board, int row) {
        if (row == board.length) {
            System.out.println("--------------------------------");
            printQueen(board);
            t++;
            return;
        }
        // System.out.println("---------------------------");
        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q'; // set Q here
            Sitqeen(board, row + 1); // function call
            board[row][j] = 'X'; // backtracking
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
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        Sitqeen(board, 0);
        System.out.println("\n total = " + t);

    }
}
