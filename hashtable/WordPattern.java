package hashtable;

import java.util.HashMap;
import java.util.Map;

// Given a pattern and a string s, find if s follows the same pattern.
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

// Example 1:
// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true

// Example 2:
// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false

// Example 3:
// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false

// Constraints:
// 1 <= pattern.length <= 300
// pattern contains only lower-case English letters.
// 1 <= s.length <= 3000
// s contains only lowercase English letters and spaces ' '.
// s does not contain any leading or trailing spaces.
// All the words in s are separated by a single space.

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] separate = s.split(" ");
        HashMap<Character, String> hm = new HashMap<>();

        for (int i = 0; i < separate.length; i++) {
            char c = pattern.charAt(i);
            String word = separate[i];
            if (hm.containsKey(c)) {
                if (!hm.get(c).equals(word)) {
                    return false;
                }
            } else if (hm.containsValue(word)) {
                return false;
            }
            hm.put(c, word);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected true): " + wordPattern("abba", "dog cat cat dog"));
        System.out.println("Testcase 2 (expected true): " + wordPattern("abbc", "dog cat cat fish"));
        System.out.println("Testcase 3 (expected false): " + wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("Testcase 4 (expected false): " + wordPattern("abba", "dog dog cat cat"));
        System.out.println("Testcase 5 (expected false): " + wordPattern("abba", "dog dog dog dog"));
        System.out.println("Testcase 5 (expected false): " + wordPattern("abc", "dog cat dog"));
    }
}
