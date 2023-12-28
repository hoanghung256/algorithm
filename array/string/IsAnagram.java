package array.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

//2 approach possible: Sorting approach and Hash table approach

public class IsAnagram {
    //Sorting approach
    //TC: O(n * log(n)) (because of build-in function Arrays.sort())
    //SC: O(n)
    public static boolean isAnagram1(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    //HashMap approach: store each character of s and its frequency into map, decrease frequency of correspond character in t
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!hm.containsKey(c)) {
                return false;
            } else {
                int frequency = hm.get(c);
                if (frequency == 0) {
                    hm.remove(c);
                } else {
                    hm.put(c, frequency - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a1 = "anagram";
        String a2 = "nagaram";
        String b1 = "fat";
        String b2 = "car";

        System.out.println("Test case 1 (expected true): " + isAnagram2(a1, a2));
        System.out.println("Test case 2 (expected false): " + isAnagram2(b1, b2));
    }
}
