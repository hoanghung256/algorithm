package math;

import java.util.Random;

// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.

// Example 1:
// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].

// Example 2:
// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Incrementing by one gives 4321 + 1 = 4322.
// Thus, the result should be [4,3,2,2].

// Example 3:
// Input: digits = [9]
// Output: [1,0]
// Explanation: The array represents the integer 9.
// Incrementing by one gives 9 + 1 = 10.
// Thus, the result should be [1,0].

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[len + 1];
        System.out.println(result.length);
        result[0] = 1;

        return digits;
    }

    public static void main(String[] args) {
        // Arrays.stream(plusOne(generate())).forEach(i -> {
        //     System.out.print(i);
        // });
        String a = "123";
        String b = "103";
        System.out.println(a.charAt(0) + b.charAt(0));
    }

    public static int[] generate() {
        Random random = new Random();
        int len = random.nextInt(10);
        int[] r = new int[len];
        for (int i = 0; i < len; i++) {
            r[i] = random.nextInt(10);
            System.out.print(r[i]);
        }
        System.out.println("");
        return r;
    }
    
}
