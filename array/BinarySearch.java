package array;

public class BinarySearch {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 6, 8, 10 };

        System.out.println(searchInsert(a, 6));
    }
}
