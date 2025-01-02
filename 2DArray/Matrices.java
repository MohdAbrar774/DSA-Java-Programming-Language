import java.util.*;

public class Matrices {

    public static void searchMax(int matrix[][]) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] > max) {
                    max = matrix[i][j];

                }
            }
        }
        System.out.println("The maximun value in the matrix array is:-" + " " + max);

    }

    public static boolean search(int matrix[][], int key) {
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == key) {

                    System.out.println("The key is found at index" + "(" + i + "," + j + ")");
                    return true;

                }
            }
        }
        System.out.println("The key is not  found ");
        return false;

    }

    public static int diagonalSum(int matrix[][]) { // O(n) time complexity
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {

            // pd
            sum += matrix[i][i];

            // sd
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }

        }

        return sum;
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = matrix.length - 1, col = 0;

        while (row >= 0 && col < matrix[0].length) {

            if (matrix[row][col] == key) {

                System.out.print("The key is found at position :" + "(" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("Key is not found!");
        return false;
    }

    public static void main(String[] args) {
        int key = 2;
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        staircaseSearch(matrix, key);

        // System.out.println(diagonalSum(matrix));

        // int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }
        // output

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
        search(matrix, key);
    }

}
