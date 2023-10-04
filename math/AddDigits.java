package math;

// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

// Example 1:
// Input: num = 38
// Output: 2
// Explanation: The process is
// 38 --> 3 + 8 --> 11
// 11 --> 1 + 1 --> 2 
// Since 2 has only one digit, return it.

// Example 2:
// Input: num = 0
// Output: 0

public class AddDigits {
    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int result = 0;
        while (num / 10 != 0) {
            result = num % 10 + num/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("case 1 (expected 2):" + addDigits(38)); 
        System.out.println("case 2 (expected 3):" + addDigits(1974)); 
        System.out.println("case 3 (expected 7):" + addDigits(124)); 
    }
}
