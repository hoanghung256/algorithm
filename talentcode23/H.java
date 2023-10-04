package talentcode23;

import java.util.Scanner;

public class H {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int len = sc.nextInt();
        if (len == 0) {
            System.out.println();
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int min = 1000000000;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == min) {
                count++;
            }
        }

        System.out.println(count);
    }
}
