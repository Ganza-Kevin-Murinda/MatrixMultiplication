import java.util.Scanner;

public class Matrix {

    // Creates a matrix
    private static int[][] getMatrix() {
        // Prompts a user to input the size(rows and columns) of the matrix
        System.out.print("\nEnter the number of rows in the matrix: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        System.out.print("\nEnter the number of columns in the matrix: ");
        int columns = sc.nextInt();

        //verifies that both rows and columns are not 0 or negative numbers
        if(rows <= 0 || columns <= 0){
            System.out.println("Invalid Inputs: No use of non-positive rows and columns");
            System.exit(0);
        }
        // Creates a matrix of size rows and columns and insert data into the matrix
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Creates a method that takes 2 matrices, multiply them and return a third matrix
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {

        //initialization of variables to be used in multiplication
        //number of rows in matrix1
        int r1 = matrix1.length;
        //number of col in matrix1
        int c1 = matrix1[0].length;
        //number of rows in matrix2
        int r2 = matrix2.length;
        //number of col in matrix2
        int c2 = matrix2[0].length;

        int[][] matrix3 = new int[r1][c2];

        // Checks if matrix multiplication is possible (Number of columns in matrix1 must equal the Number of rows in matrix2)
        if(c1 != r2){
            System.out.println("\nMultiplication is not possible, you must adhere to the rules of matrix multiplication");
            System.out.println("Rule 1:\n The number of columns in the 1 matrix must be equal to the number of rows in the 2 matrix.");
            System.out.println("Rule 2:\n The resultant matrix has the number of rows equal total number of rows in the 1 matrix \n and the number of columns equal total number of columns in the 2 matrix.");
            System.exit(0);
        }
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < r2; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }

            }
        }
        return matrix3;
    }

    public static void main(String[] args) {
        System.out.println("Create The first Matrix");
        int[][] matrixA = getMatrix();
        System.out.println("\nCreate The Second Matrix");
        int[][] matrixB = getMatrix();

        //Calls the method to multiply the matrixA and matrixB
        int[][] matrixC = multiplyMatrices(matrixA, matrixB);

        // Displaying the output
        System.out.println("\nMatrix A: "+ matrixA.length + "," + matrixA[0].length);
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix B: "+ matrixB.length + "," + matrixB[0].length);
        for(int i = 0; i<matrixB.length; i++){
            for(int j = 0; j < matrixB[i].length; j++){
                System.out.print(matrixB[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix C:");
        for (int i = 0; i < matrixC.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrixC[i].length; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println("|");
        }


    }
}
