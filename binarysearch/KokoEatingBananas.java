package binarysearch;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * 
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * 
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * 
 * Constraints:
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            return (int) Math.ceil((double) piles[0] / h);
        }
        int i = 0;
        int j = getMax(piles);

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (canFinishOnTime(piles, mid, h)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    private static boolean canFinishOnTime(int[] piles, int k, int h) {
        int time = 0;

        for (int i = 0; i < piles.length; i++) {
            time += Math.ceil((double) piles[i] / k);
            if (time > h) return false;
        }

        return time <= h;
    }

    private static int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int n : piles) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expect 4): " + minEatingSpeed(new int[] {3,6,7,11}, 8));
        System.out.println("Testcase 1 (expect 30): " + minEatingSpeed(new int[] {30,11,23,4,20}, 5));
        System.out.println("Testcase 1 (expect 23): " + minEatingSpeed(new int[] {30,11,23,4,20}, 6));
        System.out.println("Testcase 4 (expect 2): " + minEatingSpeed(new int[] { 312884470 }, 312884469));
        System.out.println("Testcase 5 (expect 14): " + minEatingSpeed(new int[] { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293,
                                                                        112677673, 679580077, 337406589, 290818316, 877337160, 901728858,
                                                                        679284947, 688210097, 692137887, 718203285, 629455728, 941802184 },
                                                                    823855818));
    }
}
