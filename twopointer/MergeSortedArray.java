package twopointer;

import java.util.Arrays;

public class MergeSortedArray {
    // Two pointers technic with built-in function Arrays.sort()
    // Merge first then sort with Arrays.sort()
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        while (i < nums1.length) {
            if (i >= m) {
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }

        Arrays.sort(nums1);
    }

    // Two pointers technic, merge and sort in 1 loop
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        while (i < nums1.length) {
            if (nums1[i] < nums1[i + 1] || i < m) {
                if (nums1[i] > nums2[j]) {
                    nums1[i] = nums2[j];
                    nums1[i + 1] = nums1[i];
                    i++;
                    j++;
                    continue;
                } else {
                    i++;
                    continue;
                }
            }
            if (nums1[i] < nums1[i + 1] || i > m) {
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge2(nums1, 3, nums2, 3);
        System.out.println("Test case : " + Arrays.toString(nums1));
    }
}
