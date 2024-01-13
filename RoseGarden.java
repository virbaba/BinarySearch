public class Solution {
    public static boolean checkBouqute(int[] arr, int mid, int k, int m) {
        int count = 0;
        int complete = 0;
        for (int ele : arr) {
            if (ele <= mid) {
                count++;
                if (count == k) {
                    complete += count / k;
                    count = 0;
                    if (complete == m)
                        return true;
                }
            }
            else
                count = 0;
        }
        return false;
    }

    public static int roseGarden(int[] arr, int k, int m) {
        // Write your code here.
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (s > ele)
                s = ele;
            if (e < ele)
                e = ele;
        }
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (checkBouqute(arr, mid, k, m)) {
                ans = mid;
                e = mid - 1;
            } else
                s = mid + 1;
        }

        return ans;
    }
}
