package TwoD_Array;
/*
 * all qustion related to the two Dimention Array
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoDArrPls {

    // Zigzag (or diagonal) traversal of Matrix
    public static void Zigzag(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length - 1;
        for (int i = 0; i < row + col; i++) {
            int j = 0;
            int r = i;
            if (i < row) {
                while (r >= 0 && j <= col) {
                    System.out.print("  " + matrix[r][j]);
                    r--;
                    j++;
                }

            } else {
                int r2 = row - 1;
                int c = i - r2 + 1;
                while (c <= col) {
                    System.out.print("  " + matrix[r2][c]);
                    r2--;
                    c++;
                }

            }
            System.out.println("");
        }

    }

    // 73. Set Matrix Zeroes
    public static void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) // checking there is 0 in first row
                        fr = true;
                    if (j == 0) // checking there is 0 in first col
                        fc = true;
                    matrix[0][j] = 0; // put zero int the 0 row
                    matrix[i][0] = 0; // put zero int the 0 col
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // checking zeros in the 0 row and 0 col
                    matrix[i][j] = 0; // set this place to 0
                }
            }
        }
        // make 0 row to all zeros
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        // make 0 to all zeros
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 54. Spiral Matrix
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int stRow = 0, stCol = 0;
        int eRow = matrix.length - 1;
        int eCol = matrix[0].length - 1;

        while (stRow <= eRow && stCol <= eCol) {

            // top
            for (int j = stCol; j <= eCol; j++) {
                // System.out.print(" " + matrix[stRow][j]);
                list.add(matrix[stRow][j]);
            }

            // right
            for (int i = stRow + 1; i <= eRow; i++) {
                // System.out.print(" " + matrix[i][eCol]);
                list.add(matrix[i][eCol]);
            }

            // bottom
            for (int j = eCol - 1; j >= stCol; j--) {
                if (stRow == eRow) {
                    break;
                }
                // System.out.print(" " + matrix[eRow][j]);

                list.add(matrix[eRow][j]);
            }

            // left
            for (int i = eRow - 1; i >= stRow + 1; i--) {
                if (stCol == eCol) {
                    break;
                }
                list.add(matrix[i][stCol]);
            }
            stRow++;
            stCol++;
            eRow--;
            eCol--;
        }
        return list;
    }

    // 48 Rotate Image
    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = matrix[i][j];
                System.out.print(" " + temp);
            }
            System.out.println();
        }
    }

    // 79 Word search in 2D Array
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recursion(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean recursion(char[][] arr, int x, int y, int index, String word) {
        if (x < 0 || y < 0 || arr[x][y] == '#') {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        char temp = arr[x][y];
        arr[x][y] = '#';

        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;

        if (x < arr.length - 1 && arr[x + 1][y] == word.charAt(index + 1)) {
            a = recursion(arr, x + 1, y, index + 1, word);
        }

        if (y < arr[x].length - 1 && arr[x][y + 1] == word.charAt(index + 1)) {
            b = recursion(arr, x, y + 1, index + 1, word);
        }

        if (x > 0 && arr[x - 1][y] == word.charAt(index + 1)) {
            c = recursion(arr, x - 1, y, index + 1, word);
        }

        if (y > 0 && arr[x][y - 1] == word.charAt(index + 1)) {
            d = recursion(arr, x, y - 1, index + 1, word);
        }

        arr[x][y] = temp;
        return a || b || c || d;
    }

    // Find a common element in all rows of a given row-wise sorted matrix

    public static void commonElement(int[][] matrix) {
        int localMax = 0, finalMax = 0, r = matrix.length - 1, c = matrix[0].length - 1;
        int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < r; i++) {
            if (localMax < matrix[i][0]) {
                localMax = matrix[i][0];
            }
        }
        finalMax = matrix[0][c];

        for (int j = 0; j <= c; j++) {
            if (matrix[0][j] >= localMax) {
                map.put(matrix[0][j], 0);
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                if (matrix[i][j] > finalMax) {
                    break;
                } else {
                    if (map.containsKey(matrix[i][j])) {
                        map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
                    }
                }
            }
        }

        if (map.containsKey(r + 2)) {
            for (Map.Entry<Integer, Integer> mapElement : map.entrySet()) {
                int value = (mapElement.getKey());
                if (value == r + 2) { // r+2 === matrix.lenght (total rows)
                    System.out.println(value);
                    ans = value;
                    return;
                }
            }

        }
        System.out.println("not fount any values");
    }

    // Create a matrix with alternating rectangles of O and X
    public static void alternateRectangle(char[][] martix) {
        int M = martix.length;
        int N = martix[0].length;

        int stRow = 0, stCol = 0, enRow = M - 1, enCol = N - 1;
        char x = 'X';
        while (stRow <= enRow && stCol <= enCol) {
            // top
            for (int j = stCol; j <= enCol; j++) {
                martix[stRow][j] = x;
            }
            // right
            for (int i = stRow + 1; i <= enRow; i++) {
                martix[i][enCol] = x;
            }
            // bottom
            for (int j = enCol - 1; j >= stCol; j--) {
                if (stRow == enRow) {
                    break;
                }
                martix[enRow][j] = x;
            }

            // left
            for (int i = enRow - 1; i >= stRow + 1; i--) {
                if (stCol == enCol) {
                    break;
                }
                martix[i][stCol] = x;
            }

            // change X to o
            // Flip character for next iteration
            x = (x == '|') ? 'X' : '|';

            stRow++;
            stCol++;
            enRow--;
            enCol--;
        }

        System.out.println("");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("" + martix[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        // int matrix[][] = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 },
        // { 17, 18, 19, 20 },
        // };
        // Zigzag(matrix);

        // int[][] matrix = {
        // { 1, 1, 1 },
        // { 1, 0, 1 },
        // { 1, 1, 1 }
        // };
        // setZeroes(matrix);
        // System.out.println("");
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // System.out.print(" " + matrix[i][j]);
        // }
        // System.out.println("");
        // }
        // System.out.println();
        // List<Integer> result = spiralOrder(matrix);
        // System.out.println();
        // for (Integer integer : result) {
        // System.out.print(" " + integer);
        // }
        // System.out.println();
        // int[][] matrix = {
        // { 5, 1, 9, 11 },
        // { 2, 4, 8, 10 },
        // { 13, 3, 6, 7 },
        // { 15, 14, 12, 16 }
        // };
        // rotate(matrix);

        // char[][] board = {
        // { 'A', 'B', 'C', 'E' },
        // { 'S', 'F', 'C', 'S' },
        // { 'A', 'D', 'E', 'E' }
        // };
        // System.out.println(exist(board, "ABCCED"));

        // int[][] mat = {
        // { 1, 2, 3, 4, 5 },
        // { 2, 4, 5, 8, 10 },
        // { 3, 5, 7, 9, 11 },
        // { 1, 3, 5, 7, 9 }
        // };
        // commonElement(mat);

        char[][] board = new char[15][15];
        alternateRectangle(board);

    }
}
