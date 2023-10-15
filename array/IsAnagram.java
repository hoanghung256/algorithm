package array;

import java.util.Arrays;

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// Constraints:
// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

//Note: 2 approach possible are sorting approach and hash table approach

public class IsAnagram {
    //Sorting approach
    public static boolean isAnagram(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);

        if (Arrays.equals(s_char, t_char)) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        String a1 = "anagram";
        String a2 = "nagaram";
        String b1 = "fat";
        String b2 = "car";

        System.out.println("Test case 1 (expected true): " + isAnagram(a1, a2));
        System.out.println("Test case 2 (expected false): " + isAnagram(b1, b2));
    }
}
