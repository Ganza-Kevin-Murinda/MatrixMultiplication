import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static int[] parseMatrixSize(String rawSize) {
        int[] size = new int[2];
        try {
            String[] stringSize = rawSize.trim().split(",");
            // Check if the given matrix size has of length of 2
            if (stringSize.length != 2) {
                throw new NumberFormatException();
            }
            for (int i = 0; i < stringSize.length; i++) {
                int rowOrColSize = Integer.parseInt(stringSize[i]);
                // row or column should not be >= 1
                if (rowOrColSize < 1) {
                    throw new NumberFormatException();
                }
                size[i] = rowOrColSize;
            }
        } catch (NumberFormatException e) {
            System.err.printf("Invalid matrix size format, we expect a comma(,) between numbers - %s", rawSize);
            System.exit(0);
        }
        // For debugging purposes, but to be removed
        System.out.println(size[0] + "," + size[1]);
        return size;
    }

    private static int[][] parseMatrixData(String rawData, int[] size) {
        int[][] data = new int[size[0]][size[1]];
        try {
            // snippet ...
        } catch (NumberFormatException e) {
            System.err.printf("Invalid matrix data format - %s", rawData);
            System.exit(0);
        }
        return data;
    }

    private static Stack<int[][]> getMatrices() {
        Scanner prompt = new Scanner(System.in);
        Stack<int[][]> matrices = new Stack<>();

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter matrix size (2,3): ");
            // Take matrix size from user
            String rawSize = prompt.nextLine();
            // Verify and convert matrix from string to array of integers
            int[] size = parseMatrixSize(rawSize);
            // Take matrix data from user
            System.out.printf("\nEnter matrix data (%d,%d): ", size[0], size[1]);
            String rawData = prompt.nextLine();
            int[][] data = parseMatrixData(rawData, size);
            // Update our matrix stack
            matrices.push(data);
        }
        return matrices;
    }

    public static void main(String[] args) {
        Stack<int[][]> matrices = getMatrices();
    }
}