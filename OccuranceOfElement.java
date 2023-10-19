public class Solution {
    public static int count(int arr[], int n, int k) {
        //Your code goes here
        int first = -1;
        int last = -1;

        int si = 0;
        int ei = n - 1;

        // To find first position
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == k) {
                first = mid;
                ei = mid - 1;
            } else if (arr[mid] < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        si = 0;
        ei = n - 1;

        // To find last position
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == k) {
                last = mid;
                si = mid + 1;
            } else if (arr[mid] < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
      // maean no occurance
        if(first == -1)
            return 0;
      
        return last - first + 1;
    }
}
