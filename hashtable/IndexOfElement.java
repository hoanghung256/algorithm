package hashtable;

import java.util.HashMap;

public class IndexOfElement {
    //Return index of third n in nums
    public static int indexOfElement(int[] nums, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //<Value, Frequency>

        for (int i = 0; i < nums.length; i++) {
            int frequency = hm.getOrDefault(nums[i], 0) + 1; 
            if (frequency == 3) {
                return i;
            }
            hm.put(nums[i], frequency);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 6): " + indexOfElement(new int[] {1,2,3,2,5,1,2,3}, 2));
    }
}
