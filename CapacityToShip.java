import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean check(int[] weights, int d, int mid) {
    int days = 1;
    int sum = 0;

    for (int ele : weights) {
        if (sum + ele > mid) {
            days++;
            sum = ele;
        } else {
            sum += ele;
        }
    }

    return days <= d;
}
    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
        int s = Integer.MIN_VALUE;
        for(int w : weights){
            s = Math.max(s, w);
        }
        int e = 0;
         for(int w : weights){
            e += w;
        }
        int ans = 0;
        while(s <= e){
            int mid = s + (e - s) / 2;
            if(check(weights, d, mid)){
                ans = mid;
                e = mid - 1;
            }
            else
                s = mid + 1;
        }
        return ans;
    }
}
