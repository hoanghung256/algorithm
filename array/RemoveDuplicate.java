package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

//You are given s string consisting of lowercase English letters. 
//A duplicate removal consists of choosing two adjacent and equal letters and removing them.

//Example 1: 
//Input: s = "abbaca"
//Output: "ca"

public class RemoveDuplicate {
    //HashSet approach
    public static String removeDuplicate1(String s) {
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

    //Two pointer approach
    public static String removeDuplicate2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int j = 1;

        while (j < sb.length()) {
            char a = sb.charAt(0);
            char b = sb.charAt(j);
            if (a != b) {
                j++;
            } else if (a == b) {
                sb.deleteCharAt(0);
                sb.deleteCharAt(j - 1);     //Because delete char at 0, the index of duplicate char minus to 1 
                j = 1;
            }
        }
        return sb.toString();
    }

    //HashMap approach
    public static String removeKDuplicate(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        String result = new String(s);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int frequency = hm.getOrDefault(c, 0) + 1; // First occurrence will be set default by 0
            if (frequency == k) {
                result = result.replaceAll(c + "", "");
                continue;
            }
            hm.put(c, frequency);
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println("Testcase 1 (expected ca): " + removeDuplicate2("abbaca"));
        System.out.println("Testcase 2 (expected caa): " + removeKDuplicate("deeedbdbcccbcaa", 3));
    }
}
