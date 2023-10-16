package sorting;

public class staircaseSearch {
    public static boolean stSearch(int[][] matrix, int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Fount at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Not Fount !");
        return false;
        // time complexity O(row+col)
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 31, 33, 39, 50 } };

        int key = 39;
        boolean re = stSearch(mat, key);
        System.out.println(re);
    }
}
