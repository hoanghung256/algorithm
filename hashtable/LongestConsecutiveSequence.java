package hashtable;

import java.util.Arrays;
import java.util.HashSet;

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Constraints:
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109

public class LongestConsecutiveSequence {
    //HashSet approach
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        int length = 0;

        for (int num : nums) {
            hs.add(num);
        }
        System.out.println(hs.toString());

        for (int num : nums) {
            if (hs.contains(num - 1) && hs.contains(num + 1)) {
                length++;
                continue;
            } else if (hs.contains(num + 1) || hs.contains(num - 1)) {
                length++;
            }
        }
        return length;
    }

    //Sorting approach (may haven't succeed)
    public static int longestConsecutive2(int[] nums) {
        Arrays.sort(nums);
        int length = 1;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1] && nums[i] - 1 == nums[i - 1]) {
                length++;
                continue;
            } if (nums[i] + 1 == nums[i + 1] || nums[i] - 1 == nums[i - 1]) {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 4): " + longestConsecutive2(new int[] {100,4,200,1,3,2}));
        System.out.println("Testcase 2 (expected 9): " + longestConsecutive2(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println("Testcase 3 (expected 2): " + longestConsecutive2(new int[] {0,0,-1}));
    }
}
