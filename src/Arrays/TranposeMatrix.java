package Arrays;

public class TranposeMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {2,3,4},
                {5,6,4},
        };

        int[][] transpose = new int[matrix[0].length][matrix.length];

        System.out.println("Matrix: ");
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                    transpose[col][row] =matrix[row][col];
            }
                System.out.println();
        }

        System.out.println("Transpose of that matrix is: ");

        for (int a = 0; a < transpose.length; a++) {
            for (int b = 0; b < transpose[0].length; b++) {
                System.out.print(transpose[a][b] + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }

    }
}