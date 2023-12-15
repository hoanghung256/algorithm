package twopointer;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1; // index of unique element

        while (i < nums.length) {
            if (nums[i] != nums[i-1]) { //found a unique element
                nums[j] = nums[i];      //push the unique up to 1 slot
                j++;
            }
            i++;
        }
        return j;

    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 1, 2, 2, 3, 3, 4};
        // int[] expected = { 0, 1, 2, 3, 4 }; // The expected answer with correct length

        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }
}
