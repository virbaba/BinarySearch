import java.util.ArrayList;

public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here

        // how much min element need in first array
        int low = Math.max(0, k - m);
        // how much max element need in first array
        int high = Math.min(n, k);

        while (low <= high) {
            int aleft = low + (high - low) / 2;
            // k - aleft mean total need k and we took aleft size element from first array
            int bleft = k - aleft;

            int aMax = (aleft == 0) ? Integer.MIN_VALUE : arr1.get(aleft - 1);
            int aMin = (aleft == n) ? Integer.MAX_VALUE : arr1.get(aleft);

            int bMax = (bleft == 0) ? Integer.MIN_VALUE : arr2.get(bleft - 1);
            int bMin = (bleft == m) ? Integer.MAX_VALUE : arr2.get(bleft);

            if (aMax <= bMin && bMax <= aMin) {
                return Math.max(aMax, bMax);
            } else if (aMax > bMin) {
                high = aleft - 1;
            } else {
                low = aleft + 1;
            }
        }

        throw new IllegalArgumentException("Invalid value of k.");

    }
}
