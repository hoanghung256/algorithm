package talentcode23;

import java.util.Scanner;

public class CensorshipForChildren {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dic = sc.nextLine();
        String com = sc.nextLine();
        sc.close();

        String[] spl_dic = dic.split(" ");
        String[] spl_com = com.split(" ");

        for (int i = 0; i < spl_com.length; i++) {
            for (int j = 0; j < spl_dic.length; j++) {
                if (spl_com[i].equalsIgnoreCase(spl_dic[j])) {
                    spl_com[i] = replaceMiddleCharacters(spl_com[i]);
                } 
            }
        }
        StringBuilder sb = new StringBuilder();

        for (String str : spl_com) {
            sb.append(str + " "); 
        }
        String result = sb.toString();
        System.out.println(result);
    }

    public static String replaceMiddleCharacters(String str) {
        if (str.length() <= 2) {
            return str;
        }
        String firstCharacter = str.substring(0, 1);
        String lastCharacter = str.substring(str.length() - 1);
        String middleCharacters = "*".repeat(str.length() - 2);
        return firstCharacter + middleCharacters + lastCharacter;
    }
}
