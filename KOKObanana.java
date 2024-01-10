public class Solution {
    public static long calTime(int[] v, int mid) {
        long count = 0;
        for (int banana : v) {
            count += (banana + mid - 1) / mid;
        }
        return count;
    }

    public static int minimumRateToEatBananas(int[] v, int h) {
        // Write Your Code Here
        int max = 0;
        for (int e : v) {
            max = Math.max(max, e);
        }

        int s = 1, e = max;
        int ans = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            long time = calTime(v, mid);
            if (time <= h) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }
}
