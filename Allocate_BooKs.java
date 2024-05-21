 import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public static int check(ArrayList<Integer> arr, int mid){
        int sum = 0;
        int s = 1;
        for(int e : arr){
            if(sum + e > mid){
                s++;
                sum = 0;
            }
            sum += e;
        }
        return s;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        // if number of student is greater than to book 
        if(m > n)
            return -1;
        int s = Integer.MIN_VALUE;
        int e = 0;
        
        for(int ele : arr){
            s = Math.max(s, ele);
            e += ele;
        }
        
        while(s <= e){
            int mid = s + (e - s) / 2;
            int student = check(arr, mid);
            if(student == m){
                e = mid - 1;
            }else if(student > m)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }
}
