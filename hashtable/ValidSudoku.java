package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // for (int i = 0; i < 9; i++) {
        //     boolean isValidColumn = isValidRow(board, i);
        //     boolean isValidRow = isValidColumn(board, i);
            
        //     if (!isValidColumn || !isValidRow) {
        //         return false;
        //     }
        // }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean isValidBox = isValidSubBox(board, i, j);
                if (!isValidBox) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidSubBox(char[][] board, int i, int j) {
        Map<Integer, Integer> map = new HashMap<>();
        int endI = i + 3;
        int endJ = j + 3;

        while (i < endI) {
            while (j < endJ) {
                if (board[i][j] == '.') {
                    j++;
                    continue;
                }
                Integer n = board[i][j++] - '0';
                Integer frequency = map.get(n);

                if (frequency == null) {
                    map.put(n , 1);
                } else {
                    return false;
                }
            }
            i++;
            j = endJ - 3;
        }

        return true;
    }

    private static boolean isValidRow(char[][] board, int rowIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        int columnIndex = 0;

        while (columnIndex < 9) {
            if (board[rowIndex][columnIndex] == '.') {
                columnIndex++;
                continue;
            }
            Integer n = board[rowIndex][columnIndex++] - '0';
            Integer frequency = map.get(n);

            if (frequency == null) {
                map.put(n , 1);
            } else {
                return false;
            }
            
        }

        return true;
    }

    private static boolean isValidColumn(char[][] board, int columnIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        int rowIndex = 0;

        while (rowIndex < 9) {
            if (board[rowIndex][columnIndex] == '.') {
                rowIndex++;
                continue;
            }
            Integer n = board[rowIndex++][columnIndex] - '0';
            Integer frequency = map.get(n);

            if (frequency == null) {
                map.put(n , 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected false): " + isValidSudoku(new char[][] {
            {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
            {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
            {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
            {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }
}
