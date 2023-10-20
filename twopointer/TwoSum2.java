package twopointer;

import java.util.Arrays;
import java.util.HashMap;

// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
// The tests are generated such that there is exactly one solution. You may not use the same element twice.
// Your solution must use only constant extra space.

// Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

// Example 2:
// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

// Example 3:
// Input: numbers = [-1,0], target = -1
// Output: [1,2]
// Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

// Constraints:
// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers is sorted in non-decreasing order.
// -1000 <= target <= 1000
// The tests are generated such that there is exactly one solution.

public class TwoSum2 {
    //Two pointers approach -> TC: O(n) SC: O(1)
    public static int[] twoSumII(int[] nums, int target) {      
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;

        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left+1, right+1};
            } else if (sum < target) {
                left++;
                continue;
            }
            right--;
        }
        return new int[] {};
    }

    //Binary search approach -> TC: O(n.log(n)) SC: O(1)
    public static int[] twoSumII2(int[] nums, int target) {     
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length-1;
            while (left <= right) {
                mid = left + (right-left)/2;
                if (nums[mid] == target - nums[i]) {
                    return new int[] {i+1, mid+1};
                } else if (nums[mid] < target - nums[i]) {
                    left = mid + 1;
                    continue;
                }
                right = mid - 1;
            }
        }
        return new int[] {};
    }

    //HashMap approach -> TC: O(n) SC: O(n). However Twopointers is better than HashMap because of using additional data structure: HashMap
    public static int[] twoSumII3(int[] nums, int target) {  
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[] {i, hm.get(diff)+1};
            } 
            hm.putIfAbsent(nums[i], i+1);
        }
        return new int[] {};
    }


    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] b = {1,2,3,4,5,6};
        int[] c = {-1,0};


        int[] r1 = twoSumII3(a, 9);
        System.out.print("Test case 1 (expected {1,2}): ");
        Arrays.stream(r1).forEach(e -> System.out.print(e + " "));
        System.out.println();

        int[] r2 = twoSumII3(b, 11);
        System.out.print("Test case 2 (expected {5,6}): ");
        Arrays.stream(r2).forEach(e -> System.out.print(e + " "));
        System.out.println();

        int[] r3 = twoSumII3(c, -1);
        System.out.print("Test case 3 (expected {1,2}): ");
        Arrays.stream(r3).forEach(e -> System.out.print(e + " "));
    }
}
