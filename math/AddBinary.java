package math;

public class AddBinary {
    //Regular string approach 
    //Time complexity: O(n)
    //Space complexity: O(1)
    //If use + operator or concat(), java create a new String because String object in java is immutable
    public static String addBinary1(String a, String b) {
        String answer = "";
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            answer =  (sum % 2) + answer;
            carry = sum / 2;    
            i--;
            j--;
        }
        if (carry != 0) {
            answer = carry + answer;
        }
        return answer;
    }

    //String builder approach
    //Time complexity: O(n) but better performance than regular string approach because StringBuilder only interact with a string till end
    //Space complexity: O(1)
    public static String addBinary2(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            answer.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Test case 1 (expected 100): " + addBinary2("11", "1"));
        System.out.println("Test case 2 (expected 10101): " + addBinary2("1010", "1011"));
    }
}
