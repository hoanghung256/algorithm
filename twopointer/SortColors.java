package twopointer;

import utils.Functions;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * 0 : red
 * 1 : white
 * 2 : blue
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */

public class SortColors {
    // Counting technic
    public static void sortColors(int[] nums) {
        int[] countArr = new int[3];

        // Count frequency
        for (int i = 0; i < nums.length; i++) {
            countArr[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            int temp = index;
            while (index < temp + countArr[i]) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 2, 0, 2, 1, 1, 0 };
        sortColors(a);
        System.out.println("Testcase 1 (expected [0,0,1,1,2,2]): " + Functions.printArr(a));
    }
}
