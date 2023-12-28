package array;

// Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
// Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

// Example 1:
// Input: arr = [1,0,2,3,0,4,5,0]
// Output: [1,0,0,2,3,0,0,4]
// Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

// Example 2:
// Input: arr = [1,2,3]
// Output: [1,2,3]
// Explanation: After calling your function, the input array is modified to: [1,2,3]

// Constraints:
// 1 <= arr.length <= 104
// 0 <= arr[i] <= 9

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int count = 0;
        int i = 0;
        while (i < arr.length-1) {
            if (arr[i] == 0) {
                count++;
            }
            i++;
        }
        if (count == 0) return;
        int j = arr.length-1;
        
        while (j > 1) {
            if (arr[j-count] == 0) {
                arr[j-count+2] = arr[j-count+1];
                arr[j-count+1] = 0;
            }
            j--;
        }
    }

    public static void main(String[] args) {
        int[] tc1 = {1,0,2,3,0,4,5,0};      //expected: {1, 0, 0, 2, 3, 0, 0, 4}
            
        duplicateZeros(tc1);
        for (int e : tc1) {
            System.out.print(e + " ");
        }
    }
}
