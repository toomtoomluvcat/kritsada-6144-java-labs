package beapthong.kritsada.lab5;

import java.util.Arrays;

public class NumberAnalyzer {

    /* 
     * This method calculates the running averages for an array of numbers.
     * The average for each index is calculated by dividing the cumulative sum 
     * by the index+1 (1-based count).
     * @param numbers an array of integers
     * @return an array of doubles representing the running averages
     
     * Auther:Kritsada beapthong
    ID:673040614-4
    Sec:2
     */
    public static double[] calculateRunningAverages(int[] numbers) {
        double[] avgValue = new double[numbers.length]; // Array to store running averages
        int sumOfList = 0; // Keeps the cumulative sum of the numbers
        for (int i = 0; i < numbers.length; i++) {
            sumOfList += numbers[i]; // Add the current number to the sum
            avgValue[i] = (double) sumOfList / (i + 1); // Calculate the average up to this index
        }
        return avgValue; // Return the array of running averages
    }

    /* 
     * This method finds the minimum and maximum values in the array.
     * It iterates through the array and compares each value to find the min and max.
     * @param numbers an array of integers
     * @return an array containing two elements: the min and max values
     */
    public static int[] findMinMax(int[] numbers) {
        int min = Integer.MAX_VALUE; // Initialize min to the largest possible integer
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer
        for (int value : numbers) {
            if (min > value) { // If a new minimum is found, update min
                min = value;
            }
            if (max < value) { // If a new maximum is found, update max
                max = value;
            }
        }
        return new int[]{min, max}; // Return the min and max in an array
    }

    /* 
     * This method checks if the array is sorted in ascending order.
     * It compares each number with the one before it and returns false if any number is smaller than the previous one.
     * @param numbers an array of integers
     * @return true if the array is sorted, false otherwise
     */
    public static boolean isSorted(int[] numbers) {
        System.out.println("Testing if the array is sorted:");
        for (int value : numbers) {
            System.out.print(value + " "); // Print the array for visual inspection
        }
        boolean yesIsSorted = true; // Assume the array is sorted initially
        int numberBefore = numbers[0]; // Initialize the first element as the "previous" number
        for (int value : numbers) {
            if (numberBefore >= value) { // If a value is less than or equal to the previous one, the array is not sorted
                return false; // Return false immediately if found
            }
        }
        return yesIsSorted; // Return true if the loop completes without finding an unsorted pair
    }

    /* 
     * Main method to demonstrate the functionality of the other methods.
     * It creates a sample array, calculates running averages, finds the min/max values,
     * and checks if the array is sorted.
     */
    public static void main(String[] args) {
        // Main values to demonstrate the methods
        int[] arr = {4, 2, 7, 1, 9}; // Sample array of numbers
        int[] minMax = findMinMax(arr); // Find the minimum and maximum values
        double[] runningAvg = calculateRunningAverages(arr); // Calculate the running averages
        System.out.println("Testing with array: " + Arrays.toString(arr)); // Display the array
        System.out.println(String.format("Minimum value: %d \nMaximum value: %d", minMax[0], minMax[1])); // Display min/max values

        // Display the running averages
        for (int i = 0; i < runningAvg.length; i++) {
            System.err.println(String.format("Position %d: %.2f", i, runningAvg[i]));
        }

        System.out.println("\nIs sorted: " + isSorted(arr)); // Check and display if the array is sorted
    }
}
