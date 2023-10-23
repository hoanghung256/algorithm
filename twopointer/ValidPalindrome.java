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
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (!Character.isLetterOrDigit(a)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(b)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //Bad solution with O(n) space complexity because of using additional char array to store
    // public static boolean isPalindrome(String s) {
    //     char[] checkArr =  s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase().toCharArray();
    //     int i = 0;
    //     int j = checkArr.length - 1;
    //     while (i <= j) {
    //         if (checkArr[i] != checkArr[j]) {
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        System.out.println("Test case 1 (expected true): " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Test case 2 (expected false): " + isPalindrome("race a car"));
    }
}
