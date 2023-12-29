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

    public static void main(String[] args) {
        System.out.println("Test case 1: (expected 2) 3^11 mod 5 = " + findRecursiveModularExponentiation(3, 11, 5));
    }
}
