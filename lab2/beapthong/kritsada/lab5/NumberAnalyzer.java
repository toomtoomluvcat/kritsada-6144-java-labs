
package beapthong.kritsada.lab5;

import java.util.Arrays;

public class NumberAnalyzer {
    public static double[] calculateRunningAverages(int[] numbers) {
        double[] avgValue = new double[numbers.length];
        int sumOfList = 0; //keep sigma sum of number
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
            System.out.println("testing if array are sorted:");
            for(int value:numbers){
                System.out.print(value+" ");
            }
            boolean yesIsSorted=true;
            int numberbefore =numbers[0];
            for (int value:numbers){
                    if(numberbefore >= value) {
                        //if fond number that more than number before return false
                        return false;
                    }
            }
            return  yesIsSorted;
        }
    

        public static void main(String[] args) {
            //main value show
            int[] arr = {4,2,7,1,9};
            int[] minMax=findMinMax(arr);
            double[] runningAvg = calculateRunningAverages(arr);
            System.out.println("testing with array: "+Arrays.toString(arr));
            System.out.println(String.format("Minimum value: %d \nMaximum value: %d", minMax[0],minMax[1]));
            for (int i =0; i<runningAvg.length;i++){
                System.err.println(String.format("Position %d: %.2f", i,runningAvg[i]));
            }
            System.out.println("\nis sorted: "+isSorted(arr));
        }

    }

