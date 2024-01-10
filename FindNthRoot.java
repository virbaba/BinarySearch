public class Solution {
    public static int power(int n, int m){
         return (int)Math.pow(m, n);
    }
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int s = 1;
        int e = m;

        while(s <= e){
            int mid = s + (e-s)/2;
            int pow = power(n, mid);
            if(pow == m)
                return mid;
            else if(pow > m)
                e = mid - 1;
            else
                s  = mid + 1;
        }
        return -1;
    }
}
