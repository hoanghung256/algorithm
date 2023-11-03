package array;

public class PalindromeNums {
    public static int solution(int n, int m) {
        int answer = 0;
        for (int i = n; i <= m; i++) {
            if (isPalindrome(i)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
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
        System.out.println("Test case 1: " + solution(1, 100));
        System.out.println("Test case 2: " + solution(100, 300));
        System.out.println("Test case 3: " + solution(1, 500000));
    }
}
