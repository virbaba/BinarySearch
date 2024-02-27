import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
         if (n > m) {
            // Swap arrays and their sizes to ensure arr1 is smaller
            ArrayList<Integer> tempArr = arr1;
            arr1 = arr2;
            arr2 = tempArr;

            int tempN = n;
            n = m;
            m = tempN;
        }

        int low = Math.max(0, k - m);
        int high = Math.min(n, k);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int arr2Index = k - mid;

            int leftMaxArr1 = (mid == 0) ? Integer.MIN_VALUE : arr1.get(mid - 1);
            int rightMinArr1 = (mid == n) ? Integer.MAX_VALUE : arr1.get(mid);

            int leftMaxArr2 = (arr2Index == 0) ? Integer.MIN_VALUE : arr2.get(arr2Index - 1);
            int rightMinArr2 = (arr2Index == m) ? Integer.MAX_VALUE : arr2.get(arr2Index);

            if (leftMaxArr1 <= rightMinArr2 && leftMaxArr2 <= rightMinArr1) {
                return Math.max(leftMaxArr1, leftMaxArr2);
            } else if (leftMaxArr1 > rightMinArr2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        throw new IllegalArgumentException("Invalid value of k.");
        
    }
}
