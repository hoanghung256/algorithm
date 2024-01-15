package stack;

import java.util.Stack;

// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
// We repeatedly make duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

// Example 1:
// Input: s = "abbaca"
// Output: "ca"
// Explanation: 
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

// Example 2:
// Input: s = "azxxzy"
// Output: "ay"

// Constraints:
// 1 <= s.length <= 105
// s consists of lowercase English letters.

public class RemoveAllAdjacentDuplicates {
    // Stack approach
    public static String removeDuplicates1(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.empty()) {
                if (st.peek() == c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                st.push(c);
            }
        }

        return st.toString();
    }

    // StringBuilder approach
    public static String removeDuplicates2(String s) {
        StringBuilder rs = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (rs.length() != 0) {
                if (rs.charAt(rs.length() - 1) == c) {
                    rs.deleteCharAt(rs.length() - 1);
                } else {
                    rs.append(c);
                }
            } else {
                rs.append(c);
            }
        }

        return rs.toString();
    }

    public static void main(String[] args) {
        System.out.println("Testcase expected ca: " + removeDuplicates2("abbaca"));
        System.out.println("Testcase expected ay: " + removeDuplicates2("azxxzy"));
    }
}
