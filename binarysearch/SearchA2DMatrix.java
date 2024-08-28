package binarysearch;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = 0;
        int i = 0;
        int j = matrix[0].length - 1;

        while (rowIndex < matrix.length) {
            if (matrix[rowIndex][j] > target) {
                break;
            } else if (matrix[rowIndex][j] == target) {
                return true;
            }
            rowIndex++;
        }

        if (i > j) {
            return false;
        }
        if (rowIndex == matrix.length) {
            return false;
        }

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int n = matrix[rowIndex][mid];

            if (n == target) {
                return true;
            } else if(n < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // System.out.println("Testcase 1 (expected true): " + searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        // System.out.println("Testcase 2 (expected true): " + searchMatrix(new int[][] {{1}}, 1));
        System.out.println("Testcase 3 (expected false): " + searchMatrix(new int[][] {{1}}, 2));
        // System.out.println("Testcase 4 (expected true): " + searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 10));
    }
}
