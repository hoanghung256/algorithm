package stack;

import java.util.Stack;

// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
// We repeatedly make k duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

// Example 1:
// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.

// Example 2:
// Input: s = "deeedbbcccbdaa", k = 3
// Output: "aa"
// Explanation: 
// First delete "eee" and "ccc", get "ddbbbdaa"
// Then delete "bbb", get "dddaa"
// Finally delete "ddd", get "aa"

// Example 3:
// Input: s = "pbbcggttciiippooaais", k = 2
// Output: "ps"

// Constraints:
// 1 <= s.length <= 105
// 2 <= k <= 104
// s only contains lowercase English letters.1

public class RemoveAllAdjacentDuplicates2 {
    // Stack approach: use StringBuilder as Stack combine to mark array
    public static String removeDuplicates1(String s, int k) {
        int[] mark = new int[s.length()];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int last = sb.length()-1;

            if (last > 0 && sb.charAt(last) == sb.charAt(last-1)) {
                mark[last] = 1 + mark[last-1];
            } else {
                mark[last] = 1;
            }

            if (mark[last] == k) {
                sb.delete(sb.length()-k, sb.length());
            }
        }

        return sb.toString();
    }

    // Stack approach: push into a stack a int[] to store char and the consecutive appear number
    public static String removeDuplicates2(String s, int k) {
        Stack<int[]> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek()[0] == c) {
                st.peek()[1]++;
            } else {
                st.push(new int[]{c, 1});
            }
            
            if (st.peek()[1] == k) {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            int[] arr = st.pop();
            for (int i = 0; i < arr[1]; i++) { 
                sb.append((char) arr[0]);
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Test case expected abcd: " + removeDuplicates2("abcd", 2));
        System.out.println("Test case expected aa: " + removeDuplicates2("deeedbbcccbdaa", 3));
        System.out.println("Test case expected ps: " + removeDuplicates2("pbbcggttciiippooaais", 2));
        System.out.println("Test case expected abd: " + removeDuplicates2("abccccd", 2));
        System.out.println(
                "Test case expected ybth: " + removeDuplicates1("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }
}
