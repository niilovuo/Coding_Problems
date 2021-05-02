import java.util.*;
/**
 * Finds and tests the greatest non-adjacent sum from an array method.
 * @author Niilo Vuokila
 */
public class largest_sum {
    /**
     * Finds the largest sum of an array in O(n) time, based on the following problem description:
     *
     * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
     * Numbers can be negative or positive integers, including 0.
     *
     * @param arr   The array to be used for the problem
     * @return      The greatest non-adjacent sum from the input array. Returns 0 if all negative numbers.
     */
    public static int findLargestSum(int[] arr){
        int[] dp_array = new int[arr.length];
        // Set the first required values for the dynamic programming table.
        dp_array[0] = Math.max(0, arr[0]);
        dp_array[1] = Math.max(arr[0], arr[1]);
        // Calculate the largest possible value for every position in the input array in a bottom-up manner.
        for(int i = 2; i < arr.length; i++){
            dp_array[i] = Math.max(dp_array[i-1], arr[i] + dp_array[i-2]);
        }
        // Go over the array once more, to find the maximum computed value.
        int max = Integer.MIN_VALUE;
        for(int val : dp_array){
            if(max < val) max = val;
        }
        return max;
    }

    private static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            if(i != arr.length - 1) System.out.print(arr[i] + ", ");
            else System.out.print(arr[i]);
        }
        System.out.print("]\n");
    }

    public static void main(String[] args){
        Random r = new Random();
        // Creates a new array of size in the range [3, 10]
        int[] arr = new int[r.nextInt(7) + 3];

        for(int i = 0; i < arr.length; i++){
            // Assigns a value from the range [-10, 10] to each index.
            arr[i] = r.nextInt(20) - 10;
        }
        System.out.println("The array is:");
        printArray(arr);
        System.out.println("The largest sum found is: " + findLargestSum(arr));
    }
}
