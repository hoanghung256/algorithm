package array;

//Count how many palindrome from n to m
public class PalindromeNums {
    public static int solution(int n, int m) {
        int count = 0;
        for (int a = n; a <= m; a++) {
            if (isTrue(a) == true) {
                count++;
            }
        }
        return count;
    }

    public static boolean isTrue(int a) {
        String s = String.valueOf(a);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Test case 1 (expected 18): " + solution(1, 100));
        System.out.println("Test case 2 (expected 20): " + solution(100, 300));
        System.out.println("Test case 3 (expected 198): " + solution(1, 10000));
    }
}
