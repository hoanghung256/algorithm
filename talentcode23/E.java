package talentcode23;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int len = sc.nextInt();
        if (len == 0) {
            result=0;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        for (int i : arr) {
            result+=i;
        }
        System.out.println(result);
    }
}
