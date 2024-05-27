public class Solution {
    public static int[] findPeakGrid(int[][] mat) {
        // Write your code here.
        int[] ans = { -1, -1 };
        int n = mat.length;
        int m = mat[0].length;

        int s = 0, e = m - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;
            for (int row = 0; row < n; row++) {
                if (max < mat[row][mid]) {
                    max = mat[row][mid];
                    maxIndex = row;
                }
            }
            int nextElement = (mid + 1 < m) ? mat[maxIndex][mid + 1] : -1;
            int preElement = (mid - 1 >= 0) ? mat[maxIndex][mid - 1] : -1;

            if (preElement < mat[maxIndex][mid] && mat[maxIndex][mid] > nextElement) {
                ans[0] = maxIndex;
                ans[1] = mid;
                return ans;
            } else if (mat[maxIndex][mid] < nextElement)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return ans;
    }
}
