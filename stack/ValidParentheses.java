package stack;

import java.util.Stack;

public class ValidParentheses {
    //Stack approach 1: alway push the left half of parentheses, return false when meet the wrong right half, return true at the end of loop  
    //TC: O(n)
    //SC: O(n)
    public static boolean isValid1(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')' && !st.empty() && st.peek() != '(') {
                return false;
            } else if (c == '}' && !st.empty() && st.peek() != '{') {
                return false;
            } else if (c == ']' && !st.empty() && st.peek() != '[') {
                return false;
            }
        }
        return true;
    }

    //Stack approach 2: alway push in stack, pop the left half when meet the right half of parentheses. At the end, the stack size is zero if it valid
    //TC: O(n)
    //SC: O(n)
    public static boolean isValid2(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);
            if (!st.empty()) {
                if (parentheses == ')' && st.peek() == '(') {
                    st.pop();
                    continue;
                } else if (parentheses == ']' && st.peek() == '[') {
                    st.pop();
                    continue;
                } else if (parentheses == '}' && st.peek() == '{') {
                    st.pop();
                    continue;
                }
            } 
            st.push(parentheses);
        }

        return st.empty();
    }


    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected true): " + isValid1("()"));
        System.out.println("Testcase 2 (expected true): " + isValid1("()[]{}"));
        System.out.println("Testcase 3 (expected false): " + isValid1("(]"));
    }
}
