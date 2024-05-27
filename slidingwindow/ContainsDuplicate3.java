package slidingwindow;

import java.util.TreeSet;

/**
 * You are given an integer array nums and two integers indexDiff and valueDiff.
 * 
 * Find a pair of indices (i, j) such that:
 * i != j,
 * abs(i - j) <= indexDiff.
 * abs(nums[i] - nums[j]) <= valueDiff, and
 * Return true if such pair exists or false otherwise.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * Output: true
 * Explanation: We can choose (i, j) = (0, 3).
 * We satisfy the three conditions:
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 *
 * Example 2:
 * 
 * Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * Output: false
 * Explanation: After trying all the possible pairs (i, j), we cannot satisfy
 * the three conditions, so we return false.
 * 
 * Constraints:
 * 2 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 1 <= indexDiff <= nums.length
 * 0 <= valueDiff <= 109
 */

public class ContainsDuplicate3 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0)
            return false;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            // Find greatest element in set that less than or equal than the given
            Integer upperBoundOfDiff = set.floor(n + valueDiff);
            // Find least element in set that greater than or equal to the given
            Integer lowerBoundOfDiff = set.ceiling(n - valueDiff);

            if (upperBoundOfDiff != null && upperBoundOfDiff >= n) {
                return true;
            } else if (lowerBoundOfDiff != null && lowerBoundOfDiff <= n) {
                return true;
            }

            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
            set.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1(expected true): "
                + containsNearbyAlmostDuplicate(new int[] { 8, 7, 15, 1, 6, 1, 9, 15 }, 1,
                        3));
        System.out.println(
                "Testcase 2(expected false): " + containsNearbyAlmostDuplicate(new int[] { 1,
                        5, 9, 1, 5, 9 }, 2, 3));
        System.out
                .println("Testcase 3(expected true): " + containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
        System.out
                .println("Testcase 4(expected false): " + containsNearbyAlmostDuplicate(new int[] { -3, 3 }, 2, 4));
    }
}
