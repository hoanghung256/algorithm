package talentcode23;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size = sc.nextInt();
        int k = sc.nextInt();

        int[] map = new int[size*size];
        for (int i = 0; i < size*size; i++) {
            map[i] = sc.nextInt();
        }

        int cost = 0;
        int i = 5;
        while (i < size*size-1) {
            if (map[i] < map[i+5]) {
                cost = map[i+5] - map[i];
            }
        }
        System.out.println(cost);
        System.out.println(cost*k);
    }
}
