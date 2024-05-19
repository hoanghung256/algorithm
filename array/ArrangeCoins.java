package array;

/**
 * You have n coins and you want to build a staircase with these coins. The
 * staircase consists of k rows where the ith row has exactly i coins. The last
 * row of the staircase may be incomplete.
 * 
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 * 
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * 
 * Example 2:
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 * 
 * Constraints: 1 <= n <= 231 - 1
 */

public class ArrangeCoins {
    public static int arrangeCoins(int n) {
        int completeRow = 0;
        int totalCoin = n;

        for (int row = 1; row < n; row++) {
            if (totalCoin < row) {
                break;
            } else {
                totalCoin -= row;
                completeRow++;
            }
        }

        return completeRow;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 2): " + arrangeCoins(5));
        System.out.println("Testcase 2 (expected 3): " + arrangeCoins(8));
        System.out.println("Testcase 3 (expected 2): " + arrangeCoins(13));
        // System.out.println("Testcase 1 (expected 2): " + arrangeCoins(5));
        // System.out.println("Testcase 1 (expected 2): " + arrangeCoins(5));
    }
}
