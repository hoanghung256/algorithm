package math;

import java.util.Arrays;

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

// Constraints:
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        int i = 0;
        while (i < first.length() || i < last.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
                continue;
            }
            break;
        }

        return first.substring(0, i);
    }

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        String[] b = {"dog","racecar","car"};
        System.out.println("Case 1 (expected: fl): " + longestCommonPrefix(a));
        System.out.println("Case 2 (expected: ): " + longestCommonPrefix(b));
    }
}
