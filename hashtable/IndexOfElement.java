package hashtable;

import java.util.HashMap;

public class IndexOfElement {
    //Return index of k-th n in nums
    public static int indexOfK_thElement1(int[] nums, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //<Value, Frequency>

        for (int i = 0; i < nums.length; i++) {
            int frequency = hm.getOrDefault(nums[i], 0) + 1; 
            if (frequency == k) {
                return i;
            }
            hm.put(nums[i], frequency);
        }
        return -1;
    }

    //Focus on the difference of else if block and 2 if 
    public static int indexOfK_thElement2(int[] nums, int n, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                count++;
            } 
            if (count == k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 6): " + indexOfK_thElement2(new int[] {1,2,3,2,5,1,2,3}, 2, 3));
    }
}
