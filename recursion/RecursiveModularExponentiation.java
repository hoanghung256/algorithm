package recursion;

public class RecursiveModularExponentiation {
    public static int findRecursiveModularExponentiation(int b, int n, int m) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return (int) Math.pow(findRecursiveModularExponentiation(b, n/2, m), 2) % m;
        } else {
            return (int) (Math.pow(findRecursiveModularExponentiation(b, n/2, m), 2) % 5 * b%m) %m;
        }
    }

    public static int sum(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + sum(n-1);
        }
    }

    public static int sumOfOdds(int n) {
        if (n == 1) {
            return n;
        } else {
            return 2 * n - 1 + sumOfOdds(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: (expected 2) 3^11 mod 5 = " + findRecursiveModularExponentiation(3, 11, 5));
        System.out.println("Sum from 1 to 7: " + sum(7));
        System.out.println("Sum of odds: " + sumOfOdds(5));
    }
}
