package math;

import java.util.Random;
import java.lang.String;

public class IsMonotonic {
    private static boolean isMonotonic(int[] nums) {

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                isIncreasing = false;
            }
            if (nums[i - 1] < nums[i]) {
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 6, 5 };
        System.out.println(isMonotonic(a));
    }

    public static int[] generate() {
        Random random = new Random();
        int len = 10;
        int[] r = new int[len];
        for (int i = 0; i < len; i++) {
            r[i] = random.nextInt(10);
            System.out.print(r[i] + " ");
        }
        return r;
    }
}
