package slidingwindow;

import java.util.HashSet;

/**
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */

public class ContainsDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < k && i < nums.length; i++) {
            int n = nums[i];
            if (set.contains(n)) {
                return true;
            }
            set.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            int n = nums[i];

            if (set.contains(n)) {
                return true;
            }
            set.remove(nums[i - k]);
            set.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1(expected true): " + containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        System.out.println("Testcase 2(expected true): " + containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        System.out.println("Testcase 3(expected false): " + containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
    }
}
