public class Solution {
    public static double median(int[] a, int[] b) {
        // Write your code here.

        int n1 = a.length;
        int n2 = b.length;
        int te = n1 + n2;

        int s = 0, e = n1;

        while (s <= e) {
            int aleft = (s + e) / 2;
            int bleft = (te + 1) / 2 - aleft;

            int amax = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
            int amin = (aleft == n1) ? Integer.MAX_VALUE : a[aleft];

            int bmax = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];
            int bmin = (bleft == n2) ? Integer.MAX_VALUE : b[bleft];

            if (amax <= bmin && bmax <= amin) {
                if (te % 2 == 0) {
                    return (Math.max(amax, bmax) + Math.min(amin, bmin)) / 2.0;
                } else {
                    return Math.max(amax, bmax) / 1.0;
                }
            } else if (amax > bmin)
                e = aleft - 1;
            else
                s = aleft + 1;
        }

        return 0.0;
    }
}
