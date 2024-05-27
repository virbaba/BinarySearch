public final class Solution {

    public static int findLesserElement(int mat[][], int assumedMedian) {
        int lesserElement = 0;

        for (int row = 0; row < mat.length; row++) {
            int s = 0, e = mat[row].length - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (mat[row][mid] <= assumedMedian)
                    s = mid + 1;
                else
                    e = mid - 1;
            }
            lesserElement += s;
        }

        return lesserElement;
    }

    public static int findMedian(int mat[][], int m, int n) {
        // Write your code here
        // minimum of c1 column is start and max of c3 column is end
        int s = 1;
        int e = Integer.MAX_VALUE;

        // for (int i = 0; i < m; i++) {
        //     s = Math.min(s, mat[i][0]);
        //     e = Math.max(e, mat[i][n - 1]);
        // }

        int shouldLesserElement = (m * n) / 2;

        while (s <= e) {
            int assumedMedian = s + (e - s) / 2;
            int lesserElement = findLesserElement(mat, assumedMedian);

            if (lesserElement <= shouldLesserElement) {
                s = assumedMedian + 1;
            } else
                e = assumedMedian - 1;
        }

        return s;
    }
}
