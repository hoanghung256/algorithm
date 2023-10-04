package talentcode23;

import java.util.Arrays;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String[] db = new String[len];
        for (int i = 0; i < len; i++) {
            db[i] = sc.nextLine();
        }
        int num_prf = sc.nextInt();
        sc.nextLine();
        String[] prfs = new String[num_prf];
        for (int i = 0; i < num_prf; i++) {
            prfs[i]= sc.nextLine();
        }
        sc.close();

        Arrays.sort(db);
        Arrays.sort(prfs);

        int count = 0;
        for (String s : db) {
            for (String p : prfs) {
                if (s.substring(p.length()).equals(p)) {
                    count++;
                } else {
                }
            }
        }

        System.out.println(count);
    }
}
