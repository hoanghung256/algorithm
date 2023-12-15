package twopointer;

import java.util.Arrays;

public class SquaresSortedArray {
    //Two pointer approach 1: find the index of min value as pivot 
    //add smaller square into result array (need to handle the rest of nums at the end)
    //TC: O(n);
    //SC: O(n);
    public static int[] sortedSquares1(int[] nums) {
        int minIndex = 0;
        int min = 100000;
        //Find index of min value as pivot
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < min) {
                min = abs;
                minIndex = i;
            }
        }

        int i = minIndex - 1;
        int j = minIndex + 1;
        int[] result = new int[nums.length];
        result[0] = nums[minIndex] * nums[minIndex];
        int index = 1;

        while (i >= 0 && j < nums.length) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left < right) {
                result[index] = left;
                i--;
            } else if (left >= right) {
                result[index] = right;
                j++; 
            }
            index++;
        }

        //Handle the rest of nums
        while (i >= 0) {
            result[index++] = nums[i] * nums[i--];
        }

        while (j < nums.length) {
            result[index++] = nums[j] * nums[j++];
        }

        return result;
    }   

    //Two pointers approach 2: two pointer at start and end of nums, add larger square into the and of result array
    //Better then approach 1 because do not need to find pivot
    public static int[] sortedSquares2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[j + 1];
        int index = j;

        while (index >= 0) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];

            if (left <= right) {
                result[index--] = right;
                j--;
            } else if (left > right) {
                result[index--] = left;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result1 = sortedSquares2(new int[] {-4,-1,0,-3,-10});
        int[] result2 = sortedSquares2(new int[] {-4,-3,0,1,2,5,6});
        System.out.println("Testcase 1 (expected [0,1,9,16,100]): " + Arrays.toString(result1));
        System.out.println("Testcase 2 (expected [0, 1, 4, 9, 16, 25, 36]): " + Arrays.toString(result2));
    }
}
