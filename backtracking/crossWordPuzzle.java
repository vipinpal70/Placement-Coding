package backtracking;
/*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */

public class crossWordPuzzle {

    // public static List<String> crosswordPuzzle(List<String> crossword, String
    // words) {
    // // Write your code here

    // }
    public static void crosswordPuzzle(char[][] crossword, String[] words, int ind) {
        // base case
        if (ind == words.length) {
            printPuzzle(crossword);
            return;
        }

        // recursive case
        String word = words[ind];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (crossword[i][j] == '-' || crossword[i][j] == word.charAt(0)) {
                    if (canWePlaceHorizontally(crossword, word, i, j)) {
                        System.out.println("inside horizontal");
                        boolean[] wePlaced = placesHorizontally(crossword, word, i, j);
                        crosswordPuzzle(crossword, words, ind + 1);
                        unPlaceHorizontally(crossword, wePlaced, i, j);
                    }

                    if (canWePlaceVertically(crossword, word, i, j)) {
                        System.out.println("inside vertical");
                        boolean[] wePlaced = placesVertically(crossword, word, i, j);
                        crosswordPuzzle(crossword, words, ind + 1);
                        unPlaceVertically(crossword, wePlaced, i, j);
                    }
                }
            }
        }

    }

    public static boolean canWePlaceHorizontally(char[][] crossword, String word, int i, int j) {
        // boundry case
        if (j - 1 >= 0 && crossword[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < crossword[0].length && crossword[i][j + word.length()] != '+') {
            return false;
        }
        for (int j2 = 0; j2 < word.length(); j2++) {
            // not enough place to put the word
            if (j + j2 >= crossword[0].length) {
                return false;
            }
            // checking already placed character is valid character or not
            if (crossword[i][j + j2] == '-' || crossword[i][j + j2] == word.charAt(j2)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public static boolean canWePlaceVertically(char[][] crossword, String word, int i, int j) {
        // boundry case
        if (i - 1 >= 0 && crossword[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() < crossword.length && crossword[i + word.length()][j] != '+') {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            // not enough place to put the word
            if (i + ii >= crossword.length) {
                return false;
            }
            // checking already placed character is valid character or not
            if (crossword[i + ii][j] == '-' || crossword[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public static boolean[] placesHorizontally(char[][] crossword, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (crossword[i][j + jj] == '-') {
                crossword[i][j + jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
        return wePlaced;
    }

    public static boolean[] placesVertically(char[][] crossword, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (crossword[i + ii][j] == '-') {
                crossword[i + ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
        return wePlaced;
    }

    public static void unPlaceHorizontally(char[][] crossword, boolean[] wePlaced, int i, int j) {
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if (wePlaced[jj] == true) {
                crossword[i][j + jj] = '-';
            }
        }
    }

    public static void unPlaceVertically(char[][] crossword, boolean[] wePlaced, int i, int j) {
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if (wePlaced[ii] == true) {
                crossword[i + ii][j] = '-';
            }
        }
    }

    public static void printPuzzle(char[][] crossword) {
        System.out.println("------ Ans -----");
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword.length; j++) {
                System.out.print(" " + crossword[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        char[][] crossword = {
                { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '-', '-', '-', '-', '-', '+', '+', '+', '+' },
                { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
                { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
                { '+', '+', '-', '-', '-', '-', '-', '-', '+', '+' },
                { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
        };

        String[] words = { "LONDON", "DELHI", "ICELAND", "ANKARA" };
        crosswordPuzzle(crossword, words, 0);
    }
}
