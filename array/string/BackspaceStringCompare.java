package array.string;

// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Example 3:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

// Constraints:
// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.

// Follow up: Can you solve it in O(n) time and O(1) space?

public class BackspaceStringCompare {
    //StringBuilder approach with build-in function: deleteCharAt()
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sbs = new StringBuilder(s); 
        StringBuilder sbt = new StringBuilder(t);

        int i = 0;
        while (i < sbs.length()) {
            char a = sbs.charAt(i);
            if (a == '#' && i == 0) {
                sbs.deleteCharAt(0);
                continue;
            } else if (a == '#' && i > 0) {
                sbs.deleteCharAt(i);
                sbs.deleteCharAt(i - 1);
                i -= 1;
                continue;
            }
            i++;
        }

        int j = 0;
        while (j < sbt.length()) {
            char a = sbt.charAt(j);
            if (a == '#' && j == 0) {
                sbt.deleteCharAt(0);
                continue;
            } else if (a == '#' && j > 0) {
                sbt.deleteCharAt(j);
                sbt.deleteCharAt(j - 1);
                j -= 1;
                continue;
            }
            j++;
        }
        
        return sbs.toString().equals(sbt.toString());
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected true): " + backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
