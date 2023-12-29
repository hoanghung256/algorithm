package twopointer;

// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// Example 3:
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

// Constraints:
// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.

public class ValidPalindrome {
    //Two Pointer approach 1: ignore non-letter or non-digit characters 
    //Time complexity: O(n / 2)
    //Space complexity: O(1)
    public static boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (!Character.isLetterOrDigit(a)) {
                i++;
            } else if (!Character.isLetterOrDigit(b)) {
                j--;
            } else if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    //Two pointer approach 2: Remove all non-letter/non-digit characters but worst performance because built-in function is slow 
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static boolean isPalindrome2(String s) {
        String newS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = newS.length() - 1;
        while (i <= j) {
            if (newS.charAt(i) != newS.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Test case 1 (expected true): " + isPalindrome1("A man, a plan, a canal: Panama"));
        System.out.println("Test case 2 (expected false): " + isPalindrome1("race a car"));
    }
}
