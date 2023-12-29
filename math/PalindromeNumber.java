package math;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int origin = x;
        int reverse = 0;

        while (x > 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x /= 10;
        }
        return reverse == origin;
    }

    public static int countPalindromeInt(int n, int m) {
        int count = 0;

        for (int i = n; i <= m; i++) {
            if (isPalindrome(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println("Test case 1 (expected true): " + isPalindrome(121));
        // System.out.println("Test case 2 (expected false): " + isPalindrome(-121));

        System.out.println(countPalindromeInt(1, 500000));
    }
}
