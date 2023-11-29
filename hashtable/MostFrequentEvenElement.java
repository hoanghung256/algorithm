package hashtable;

import java.util.HashMap;

// Given an integer array nums, return the most frequent even element.
// If there is a tie, return the smallest one. If there is no such element, return -1.

// Example 1:
// Input: nums = [0,1,2,2,4,4,1]
// Output: 2
// Explanation:
// The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
// We return the smallest one, which is 2.

// Example 2:
// Input: nums = [4,4,4,9,2,4]
// Output: 4
// Explanation: 4 is the even element appears the most.

// Example 3:
// Input: nums = [29,47,21,41,13,37,25,7]
// Output: -1
// Explanation: There is no even element.

// Constraints:
// 1 <= nums.length <= 2000
// 0 <= nums[i] <= 105

public class MostFrequentEvenElement {
    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int n : nums) {
            if (n % 2 == 1) {
                continue;
            }
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }   

        if (hm.size() == 0) return -1;

        int maxFrequency = -1;
        int result = -1;
        for (int n : hm.keySet()) {
            if (hm.get(n) > maxFrequency && result < n) {
                maxFrequency = hm.get(n);
                result = n;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // System.out.println("Testcase 1 (expected 2): " + mostFrequentEven(new int[] {0,1,2,2,4,4,1}));
        // System.out.println("Testcase 2 (expected 4): " + mostFrequentEven(new int[] {4,4,4,9,2,4}));
        // System.out.println("Testcase 3 (expected -1): " + mostFrequentEven(new int[] {29,47,21,41,13,37,25,7}));
        System.out.println("Testcase 4 (expected 0): " + mostFrequentEven(new int[] {0,0,0,0}));
    }
}
