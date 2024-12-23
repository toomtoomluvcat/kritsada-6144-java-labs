
package beapthong.kritsada.lab5;

public class NumberAnalyzer {
    /*
    * The Number Analyzer program:
    * This program performs various analytical operations on an array of integers. 
    * It calculates running averages, finds the minimum and maximum values, 
    * and checks if the array is sorted.
    * 
    * The program includes three key methods:
    * - `calculateRunningAverages(int[] numbers)`: Computes running averages for the given array.
    * - `findMinMax(int[] numbers)`: Finds the minimum and maximum values in the array.
    * - `isSorted(int[] numbers)`: Checks if the array is sorted in ascending order.
    *
    * Author: Kritsada Beapthong
    * ID: 673040614-4
    * Section: 2
*/

    public static double[] calculateRunningAverages(int[] numbers) {
        double[] avgValue = new double[numbers.length];
        int sumOfList = 0; //keep sigma sum of number
        System.out.println("\nRunning average:");
        for (int i= 0;i<numbers.length;i++){
            sumOfList += numbers[i];
            avgValue[i] =(double)sumOfList/(i+1); //divide by element of number
        }
        return avgValue;
	}
    /* 
     * method find min and max value by forloop
    */
        public static int[] findMinMax(int[] numbers) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int value : numbers) {
                if (min > value) { //keep value if find new min
                    min = value;
                }
                if (max < value) {//keep value if find new max
                    max = value;
                }
            }
            
            return new int[] {min,max};
        }
        public static boolean isSorted(int[] numbers) {
            System.out.println("Testing if array are sorted:");
            for(int value:numbers){
                System.out.print(value+" ");
            }
            boolean yesIsSorted=true;
            for (int i=1;i<numbers.length;i++){
                if (numbers[i-1]>numbers[i]){
                    return false;
                }
            }
            
            return  yesIsSorted;
        }
    
        public static void main(String[] args) {
            //main value show
            int[] arr = {4,2,7,1,9};
            int[] arr2 ={1,2,3,4,5};
            int[] minMax=findMinMax(arr);  
            System.out.print("Testing with array: {");
            for (int i=0;i<arr.length;i++){
                System.err.print(i+1==arr.length? arr[i]:arr[i]+", ");
            }
            System.out.println("}");
            System.out.println(String.format("Minimum value: %d \nMaximum value: %d", minMax[0],minMax[1]));
            double[] runningAvg = calculateRunningAverages(arr);
            for (int i =0; i<runningAvg.length;i++){
                System.err.println(String.format("Position %d: %.2f", i,runningAvg[i]));
            }
            System.out.println("");
            System.out.println("\nis sorted: "+isSorted(arr));
            System.out.println("\nis sorted: "+isSorted(arr2));
        }

    }

