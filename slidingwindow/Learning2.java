package slidingwindow;

public class Learning2 {
    /**
     *  Find the number of arrange the input array that elements <= K stay around
     * Step 1: Find the number of element that <= K
     * Step 2: Find window (with side is result of step 1) that have most element <= K
     * Step 3: Move to the window above then switch the position of satisfied outside the window and the not inside
     */
    public static int minimumArrangeArrayWithK(int[] arr, int k) {
        int satisfied = 0;
        for (int n : arr) {
            if (n <= k) satisfied++;
        }
        
        int count = 0;
        for (int i = 0; i < satisfied; i++) {
            if (arr[i] <= k) 
            count++;
        }

        int res = count;
        for (int i = satisfied; i < arr.length; i++) {
            if (arr[i-satisfied] <= k) {
                count--;
            }
            if (arr[i] <= k) {
                count++;
            }
            res = Math.max(res, count);
        }

        return satisfied - res;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 1): " + minimumArrangeArrayWithK(new int[] {2,1,5,6,3}, 3));
        System.out.println("Testcase 2 (expected 2): " + minimumArrangeArrayWithK(new int[] {2,7,9,5,8,7,4}, 5));
    }
}
