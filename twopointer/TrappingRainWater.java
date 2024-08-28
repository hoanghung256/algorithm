package twopointer;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class TrappingRainWater {
    public static int trap(int[] height) {
        int totalTrapped = 0;
        int i = 0;

        while (i < height.length) {
            if (height[i] < height[i + 1]) {
                i++;
                continue;
            }
            int j = i;
            int k = i + 1;
            while (k < height.length && height[j] > height[k] && height[k] > height[k - 1]) {
                k++;
            }
            j = k;
            k++;
            while (k < height.length && height[j] < height[k] && height[k] < height[k + 1]) {
                k++;
            }
            // j = i;
            k--;

            if (height[i] < height[k]) {
                totalTrapped += findLeftTrapped(height, i, k);
            } else {
                totalTrapped += findRightTrapped(height, i, k);
            }
            i = k;
        }

        return totalTrapped;
    }

    private static int findLeftTrapped(int[] height, int i, int j) {
        int trapped = 0;
        int k = i + 1;
        
        while (height[k] < height[j]) {
            trapped += height[i] - height[k++];
        }

        return trapped;
    }

    private static int findRightTrapped(int[] height, int i, int j) {
        int trapped = 0;
        int k = j - 1;
        
        while (height[k] < height[i]) {
            trapped += height[j] - height[k--];
        }

        return trapped;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected 6): " + trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("Testcase 2 (expected 9): " + trap(new int[] {4,2,0,3,2,5}));
        // System.out.println(findRightTrapped(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}, 8, 10));
    }
}
