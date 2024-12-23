package beapthong.kritsada.lab5;

public class RecursiveMethods {
    
    /**
     * Recursively finds the sum of digits in a number. Example: For the number
     * 123, the answer is 1+2+3 = 6
     *
     * @param number the input number
     * @return sum of digits
     */
    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        }

        int lastDigit = number % 10;
        int divideNumber = number / 10;
        lastDigit += sumOfDigits(divideNumber);
        return lastDigit;
    }
    
    /**
     * Recursively reverses an array between start and end indices.
     * @param arr the array to reverse
     * @param start starting index
     * @param end ending index
     */
    public static void reverseArray(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            System.out.print(arr[start] + " ");
            return;
        }
        System.out.print(arr[end] + " ");
        reverseArray(arr, start + 1, end - 1);
        System.out.print(arr[start] + " ");
    }

    /**
     * Recursively checks if an array is palindrome.
     *
     * @param arr the array to check
     * @param start starting index
     * @param end ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int[] arr, int start, int end) {
        // Base case: if start is greater than or equal to end, the array is a palindrome
        if (start >= end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false; // If the current elements do not match, it's not a palindrome
        }
        // Recursively check the rest of the array
        return isPalindrome(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        // Demonstrate each recursive method with example inputs
        int testingNumber = 45;
        int testingNumber2 = 12345;
        System.out.println();
        int[] checked = {1, 2, 3, 4, 5};
        int[] checked2 = {1, 2, 3, 2, 1};
        int[] checked3 = {1, 2, 1, 2};
        
        System.out.println(String.format("Sum of digit in %d: %d ", testingNumber, sumOfDigits(testingNumber)));
        System.out.println(String.format("Sum of digit in %d: %d \n", testingNumber2, sumOfDigits(testingNumber2)));

        System.out.println("Original array:");
        for (int i = 0; i < checked.length; i++) {
            System.out.print(checked[i] + " ");
        }
        System.out.println("\nReversed array:");
        reverseArray(checked, 0, 4);

        System.out.println("\n\nTesting palindrome: ");
        for (int i = 0; i < checked2.length; i++) {
            System.out.print(checked2[i] + " ");
        }
        System.out.println(String.format("\nIs palindrome: %b", isPalindrome(checked2, 0, 4)));

        System.out.println("\nTesting palindrome: ");
        for (int i = 0; i < checked3.length; i++) {
            System.out.print(checked3[i] + " ");
        }
        System.out.println(String.format("\nIs palindrome: %b", isPalindrome(checked3, 0, 3)));
    }
}
