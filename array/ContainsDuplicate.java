package array;

import java.util.HashSet;

// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

// Constraints:
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109


//Note: must not use 2 for loop => O(n^2)
//should use HashSet => O(n)

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> check = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (check.contains(nums[i])) {
                return true;
            }
            check.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {1,1,1,3,3,4,3,2,4,2};

        System.out.println("Test case 1 (expected false): " + containsDuplicate(a));
        System.out.println("Test case 2 (expected true): " + containsDuplicate(b));
    }
}
