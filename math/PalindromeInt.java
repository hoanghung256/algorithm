package math;

public class PalindromeInt {
    public static boolean isPalindrome(int x) {
        int[] arr = convertToDigitsArray(x);
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length; j >= 0; j--) {
                if (arr[i] == arr[j]) {
                    check++;
                }
            }
        }
        if (check == (arr.length/2)) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] convertToDigitsArray(int number) {
        String numberString = Integer.toString(number);
        int[] digitsArray = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            digitsArray[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return digitsArray;
    }
}
