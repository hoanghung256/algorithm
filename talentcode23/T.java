package talentcode23;

import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int result = 0;
        while (a <= b) {
            result+=findDistance(a);
            a++;
        }
        System.out.println(result);
    }

    public static int findDistance(int x) {
        int divisors_sum = 0;
        for (int i = 1; i < x; i++) {
            if (x % i == 0) {
                divisors_sum+=i;
            }
        }
        if (x - divisors_sum < 0) {
            return -(x - divisors_sum);
        }
        return x - divisors_sum;
    }
}
