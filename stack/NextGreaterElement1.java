package stack;

import java.util.HashMap;

/**
 * The next greater element of some element x in an array is the first greater
 * element that is to the right of x in the same array.
 * 
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where
 * nums1 is a subset of nums2.
 * 
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] ==
 * nums2[j] and determine the next greater element of nums2[j] in nums2. If
 * there is no next greater element, then the answer for this query is -1.
 * 
 * Return an array ans of length nums1.length such that ans[i] is the next
 * greater element as described above.
 * 
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
 * the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
 * the answer is -1.
 * 
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so
 * the answer is -1.
 * 
 * Constraints:
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * All integers in nums1 and nums2 are unique.
 * All the integers of nums1 also appear in nums2.
 * 
 * Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */

public class NextGreaterElement1 {
    // Brute force approach O(nums1.length * nums2.length)
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int larger = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            larger = nums2[k];
                            break;
                        }
                    }
                }
            }
            nums1[i] = larger;
        }
        return nums1;
    }

    // HashMap approach O(nums1.length + nums2.length)
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hm.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int larger = -1;
            if (hm.containsKey(nums1[i])) {
                for (int j = hm.get(nums1[i]); j < nums2.length; j++) {
                    if (nums1[i] < nums2[j]) {
                        larger = nums2[j];
                        break;
                    }
                }
            }
            nums1[i] = larger;
        }
        return nums1;
    }

    private static String print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1(expected [-1,3,-1]): "
                + print(nextGreaterElement2(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
        System.out.println("Testcase 2(expected [3,-1]): "
                + print(nextGreaterElement2(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
        System.out.println("Testcase 3(expected [3,-1]): "
                + print(nextGreaterElement2(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));
    }
}
