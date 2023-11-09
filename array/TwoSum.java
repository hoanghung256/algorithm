package array;

import java.util.HashMap;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
 
// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
//2 nested for-loop is O(n^2)

public class TwoSum {
    public static int[] twoSum1(int[] nums, int target) {  //Using HashMap approach => O(n)
        HashMap<Integer, Integer> myMap = new HashMap<>(); 

        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (myMap.containsKey(diff)) {
                return new int[] {i, myMap.get(diff)};
            }
            myMap.put(nums[i], i);
        }
        System.out.println(myMap);

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 132, 8, 19, 7, 11, 15};
        twoSum1(nums, 9);
        for (int i : twoSum1(nums, 9)) {
            System.out.print(i + " ");
        }
    }
}
