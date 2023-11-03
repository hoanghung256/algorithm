package array;

import java.util.HashSet;

public class FindPrimes {
    public static int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isPrime(nums[i] + nums[j])) {
                    hs.add(nums[i] + nums[j]);
                }
            }
        }
        return hs.size();
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // return false if i is divisor of n
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3, 4, 5};
        System.out.println("Test case 1: " + solution(a));
        System.out.println("Test case 2: " + solution(b));
    }
}
