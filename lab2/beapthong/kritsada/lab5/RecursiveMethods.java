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
        Boolean yesIsPalindrome = arr[start] == arr[end];
		if(!yesIsPalindrome){
			return yesIsPalindrome;
		}
		if (start+1 <= end-1) {
            yesIsPalindrome = isPalindrome(arr, start + 1, end - 1);
        }
        return yesIsPalindrome;
    }

    public static void main(String[] args) {
        // Demonstrate each recursive method with example inputs
        int testingNumber =155;
        System.out.println();
        int[] checked = {1,2,2,1};
        
        System.out.println(String.format("Sum of digit in %d: %d ",testingNumber, sumOfDigits(testingNumber)));
        System.out.println("");
        System.out.println("Original array: ");
        for (int i =0; i<checked.length;i++){
            System.out.print(checked[i]+" ");
        }
        
        System.out.println("\nRevese array:");
        reverseArray(checked, 0, 3);
        System.out.println("");
        System.out.println("\ntesting palindrome:");
        for (int i =0; i<checked.length;i++){
            System.out.print(checked[i]+" ");
        }
        System.out.println("");
		System.out.println(String.format("\nIs palindrome: %b",isPalindrome(checked, 0, 3)));
    }
}
