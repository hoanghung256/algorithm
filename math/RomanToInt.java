package math;

import java.util.HashMap;

//Convert an integer number to roman
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

public class RomanToInt {
    private static int romanToInteger(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i+1) < s.length() && hm.get(s.charAt(i)) < hm.get(s.charAt(i + 1))) {
                result += hm.get(s.charAt(i+1)) - hm.get(s.charAt(i));       
                i++;        
            }else {
                 int a = hm.get(s.charAt(i));
                result += a;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println("Case 1 (expected 3): " + romanToInteger("III"));
        // System.out.println("Case 2 (expected 58): " + romanToInteger("LVIII"));
        System.out.println("Case 3 (expected 1994): " + romanToInteger("MCMXCIV"));
        System.out.println("Case 4 (expected 7): " + romanToInteger("VII"));
        System.out.println("Case 5 (expected 16): " + romanToInteger("XVI"));
        System.out.println("Case 7 (expected 99): " + romanToInteger("XCIX"));
        System.out.println("Case 9 (expected 25): " + romanToInteger("XXV"));
        System.out.println("Case 10 (expected 135): " + romanToInteger("CXXXV"));
        System.out.println("Case 12 (expected 48): " + romanToInteger("XLVIII"));
        System.out.println("Case 14 (expected 39): " + romanToInteger("XXXIX"));
        System.out.println("Case 15 (expected 72): " + romanToInteger("LXXII"));
        System.out.println("Case 16 (expected 9): " + romanToInteger("IX"));
        System.out.println("Case 17 (expected 90): " + romanToInteger("XC"));
        System.out.println("Case 18 (expected 59): " + romanToInteger("LIX"));
        System.out.println("");
        System.out.println("Case 11 (expected 86): " + romanToInteger("LXXXVI"));
        System.out.println("Case 13 (expected 80): " + romanToInteger("LXXX"));
        System.out.println("Case 8 (expected 64): " + romanToInteger("LXIV"));
        System.out.println("Case 20 (expected 24): " + romanToInteger("XXIV"));
        System.out.println("Case 6 (expected 43): " + romanToInteger("XLIII"));
        System.out.println("Case 19 (expected 1476): " + romanToInteger("MCDLXXVI"));
        System.out.println("Case 21 (expected 476): " + romanToInteger("CDLXXVI"));
    }
}
