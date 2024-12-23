package beapthong.kritsada.lab5;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    /*
 * This program allows the user to create and manipulate matrices. 
 * It provides an interactive menu to create different types of matrices 
 * such as a user-input matrix, random matrix, all-zero matrix, 
 * all-ones matrix, and diagonal matrix. 
 * After creating the matrix, the program offers various operations 
 * that can be performed on the matrix, such as transposing the matrix, 
 * calculating the sum of rows and columns, finding the minimum and maximum 
 * elements, and displaying diagonal elements (if the matrix is square).
 * 
 * The program handles matrix creation based on the user's choice and 
 * performs the selected operations on the matrix.
 * 
 * Author: Kritsada Beapthong
 * ID: 673040614-4
 * Section: 2
     */

    // Variables to hold the matrix, number of rows, columns, and scanner for user input
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);

    // Display the matrix creation menu for the user to select the matrix type
    public static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu");
        System.out.println("1. User Input Matrix"); // Allow user to input matrix elements manually
        System.out.println("2. Random Matrix (0-9)"); // Generate a matrix with random values between 0 and 9
        System.out.println("3. All Zero Matrix"); // Generate a matrix where all elements are 0
        System.out.println("4. All Ones Matrix"); // Generate a matrix where all elements are 1
        System.out.println("5. Diagonal Matrix"); // Generate a diagonal matrix with 1's along the diagonal
        System.out.print("Enter your choice: ");
    }

    /*
     * This method creates a matrix based on the user's choice:
     * 1. Manually input each element of the matrix
     * 2. Generate random values between 0 and 9
     * 3. Fill the matrix with 0's
     * 4. Fill the matrix with 1's
     * 5. Generate a diagonal matrix with 1's on the diagonal
     */
    public static void createMatrix(int choice) {
        switch (choice) {
            case 1:
                // User manually enters the elements of the matrix
                scanner.nextLine();
                System.out.println("Enter matrix element: ");
                for (int i = 0; i < matrix.length; i++) {
                    String[] input = scanner.nextLine().split(" ");
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = Integer.parseInt(input[j]);
                    }
                }
                break;
            case 2:
                // Generate a random value (0-9) for each element in the matrix
                Random random = new Random();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = random.nextInt(10);
                    }
                }
                break;
            case 3:
                // Fill the matrix with 0's
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 0;
                    }
                }
                break;
            case 4:
                // Fill the matrix with 1's
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 1;
                    }
                }
                break;
        }
    }

    // Creates a diagonal matrix with 1's along the diagonal and 0's elsewhere
    public static void createDiagonalMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == i) {
                    matrix[i][j] = 1; // Set 1 on the diagonal
                } else {
                    matrix[i][j] = 0; // Set 0 off the diagonal
                }
            }
        }
    }

    // Displays the matrix in a formatted way
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Properly format the matrix elements for display
                if ((j + 1) % matrix[0].length != 0) {
                    System.out.print(matrix[i][j] < 10 ? "   " + matrix[i][j] : "  " + matrix[i][j]);
                } else {
                    System.out.println(matrix[i][j] < 10 ? "   " + matrix[i][j] : "  " + matrix[i][j]);
                }
            }
        }
    }

    // Display the matrix operations menu for the user to select an operation
    public static void displayOperationsMenu() {
        System.out.println("Matrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Transpose the matrix and display the result
    public static void transposeMatrix() {
        int[][] newMatrix = new int[columns][rows];
        System.out.println("Transposed Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        displayMatrix(newMatrix);
    }

    // Calculate and display the sum of elements in each row and column
    public static void calculateSums() {
        System.out.println("\nRow sums:");
        for (int i = 0; i < rows; i++) {
            int sumOfRows = 0;
            for (int j = 0; j < columns; j++) {
                sumOfRows += matrix[i][j];
            }
            System.out.println(String.format("Row %d sum: %d", i + 1, sumOfRows));
        }

        System.out.println("\nColumn sums:");
        for (int i = 0; i < columns; i++) {
            int sumOfCols = 0;
            for (int j = 0; j < rows; j++) {
                sumOfCols += matrix[j][i];
            }
            System.out.println(String.format("Column %d sum: %d", i + 1, sumOfCols));
        }
        System.out.println("");

    }

    // Find and display the minimum and maximum elements in the matrix
    public static void findMinMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Traverse the matrix to find min and max elements
        for (int[] row : matrix) {
            for (int col : row) {
                if (col < min) {
                    min = col;
                }
                if (col > max) {
                    max = col;
                }
            }
        }
        System.out.println("\nMinimum element: " + min);
        System.out.println("Maximum element: " + max+"\n");
    }

    // Display diagonal elements if the matrix is square, else show an error message
    public static void displayDiagonal() {
        if (columns != rows) {
            System.out.println("\nMatrix is not square. Cannot display diagonal elements\n");
        } else {
            createDiagonalMatrix(); // If square, create and display diagonal matrix
        }
    }

    // Main method that controls the program flow
    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu(); // Display matrix creation options
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();

                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }
                matrix = new int[rows][columns];

                createMatrix(choice); // Create matrix based on user's choice
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();

                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }
                matrix = new int[rows][rows];
                System.out.println("Create Matrix:");
                createDiagonalMatrix(); // Create diagonal matrix
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            System.out.println("Created Matrix:");
            displayMatrix(matrix); // Display the created matrix
            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu(); // Display available operations
                int operation = scanner.nextInt();
                switch (operation) {
                    case 1:
                        transposeMatrix(); // Transpose the matrix
                        break;
                    case 2:
                        calculateSums(); // Calculate sums of rows and columns
                        break;
                    case 3:
                        findMinMax(); // Find the minimum and maximum values
                        break;
                    case 4:
                        displayDiagonal(); // Display the diagonal elements
                        break;
                    case 5:
                        continueProgram = false; // Exit the program
                        continueOperations = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
        scanner.close(); // Close the scanner to avoid memory leaks
    }
}
