package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

//You are given s string consisting off lowercase English letters. 
//A duplicate removal consists of choosing two adjacent and equal letters and removing them.

//Example 1: 
//Input: s = "abbaca"
//Output: "ca"

public class RemoveDuplicate {
    public static String removeDoubleDuplicate(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                continue;
            }
            hs.add(s.charAt(i));
        }
        
        String result = hs.stream().map(String::valueOf).collect(Collectors.joining(""));
        return result;
    }

    public static String removeKDuplicate(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        String result = new String(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = hm.getOrDefault(c, 0) + 1; // First occurrence will be set default by 0
            if (count == k) {
                result = result.replaceAll(Character.toString(c), "");
                continue;
            }
            hm.put(c, count);
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println("Testcase 1 (expected ca): " +
        // removeDoubleDuplicate("abbaca"));
        System.out.println("Testcase 2 (expected aa): " +
        removeKDuplicate("deeedbdbcccbaa", 3));
    }
}
