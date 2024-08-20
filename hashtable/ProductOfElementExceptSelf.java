package hashtable;

import utils.Functions;

/**
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductOfElementExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int mul = mulAll(nums);
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (mul == 0  && nums[i] == 0) {
                result[i] = mulExcept(nums, i);
            } else {
                result[i] = mul / nums[i];
            }
        }
        return result;
    }

    private static int mulExcept(int[] arr, int exceptIndex) {
        int result = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i == exceptIndex) {
                continue;
            }
            result *= arr[i];
        }

        return result;
    }

    private static int mulAll(int[] arr) {
        int result = 1;

        for (int n : arr) {
            result *= n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected [24,12,8,6]): " + Functions.printArr(productExceptSelf(new int[] {1,2,3,4})));
        System.out.println("Testcase 2 (expected [0,0,9,0,0]): " + Functions.printArr(productExceptSelf(new int[] {-1,1,0,-3,3})));
        System.out.println("Testcase 3 (expected [7560,6048,10080,4320,3780,3360]): " + Functions.printArr(productExceptSelf(new int[] {4,5,3,7,8,9})));
    }
}
