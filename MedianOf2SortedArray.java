import java.util.*;

public class Solution {
    public static double median(int[] a, int[] b) {
        // Write your code here.
        int n1 = a.length;
        int n2 = b.length;

        if (n1 > n2) {
            int[] temp = a;
            a = b;
            b = temp;

            int tempN = n1;
            n1 = n2;
            n2 = tempN;
        }

        int s = 0, e = n1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int b1 = (n1 + n2 + 1) / 2 - mid;

            int leftMaxA = (mid == 0) ? Integer.MIN_VALUE : a[mid - 1];
            int rightMinA = (mid == n1) ? Integer.MAX_VALUE : a[mid];

            int leftMaxB = (b1 == 0) ? Integer.MIN_VALUE : b[b1 - 1];
            int rightMinB = (b1 == n2) ? Integer.MAX_VALUE : b[b1];

            if (leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2.0;
                } else {
                    return Math.max(leftMaxA, leftMaxB);
                }
            } else if (leftMaxA > rightMinB) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
