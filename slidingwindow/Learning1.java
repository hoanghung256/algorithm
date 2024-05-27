package slidingwindow;

public class Learning1 {
    /**
     * Find maximum sum of sub array with K elements
     * @return sub array satisfied the required
     */
    public static int[] maximumOfSubArrayWithLengthK(int[] arr, int k) {
        int[] subArr = new int[k];
        int res = 0;
        int sum = 0;

        // Find the first window's sum
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }

        res = sum;
        int idx = 0;
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i-k] + arr[i];
            if (sum > res) {
                res = sum;
                idx = i - k + 1;
            }
        }

        for (int i = 0; i < k; i++) {
            subArr[i] = arr[idx+i];
        }
        return subArr;
    }

    public static void main(String[] args) {
        System.out.print("Testcase 1: ");
        printArr(maximumOfSubArrayWithLengthK(new int[] {1,2,3,1,5,2,7,8,9,1}, 3));
    }

    private static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
