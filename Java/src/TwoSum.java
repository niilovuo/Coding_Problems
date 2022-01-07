import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Finds two numbers from a list that add to a third target value.
 * @author Niilo Vuokila
 */
public class TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers
     * such that they add up to target.
     * Each input has exactly one solution, the same element cannot be used twice.
     * Answer can be returned in any order.
     *
     * Source of problem: https://leetcode.com/problems/two-sum/
     *
     * @param nums   The array to be used for the problem
     * @param target The target that 2 numbers need to add to
     * @return       The indexes of two numbers that add to target. Returns null if such numbers are not found.
     */
    public static int[] twoSum(int[] nums, int target) {
        Integer match = null;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
        int[] r = new int[2];

        for (int i = 0; i < nums.length; i++) {
            // Key is the value itself, value is an ArrayList
            // containing all indexes where the value is found
    
            ArrayList<Integer> bucket = hm.get(nums[i]);
            // Add a new entry using chaining (collision management)
            if (bucket == null) {
                bucket = new ArrayList<Integer>();
                bucket.add(i);
                hm.put(nums[i], bucket);
            } else {
                bucket.add(i);
            }
            bucket = hm.get(target - nums[i]);
            // Find a potential match:
            if (bucket != null) {
                for (int j = 0; j < bucket.size(); j++) {
                    if (bucket.get(j) != i) {
                        match = bucket.get(j);
                    }
                }
            }
            if (match != null && match != i) {
                r[0] = match;
                r[1] = i;
                return r;
            }
        }
        return null;
    }
    public static void main(String[] args){
        // Single test case for the algorithm:
        System.out.println("Calculated answer:\t" + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Expected answer:\t[0, 1]");
    }
}