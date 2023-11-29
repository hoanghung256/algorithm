package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle1 {
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                triangle.add(Arrays.asList(1));
                continue;
            }
            if (i == 1) {
                triangle.add(Arrays.asList(1,1));
                continue;
            }
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int left = triangle.get(i-1).get(j-1);
                int right = triangle.get(i-1).get(j);
                row.add(left + right);
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    //Better solution using math approach
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        for (int n = 0; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            int nCk = 1;
            for (int k = 0; k <= n; k++) {
                row.add(nCk);
                nCk = nCk * (n-k) / (k+1);
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1: " + generate2(5));
    }
}
