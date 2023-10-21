/*
  for solve this problem firstly solve painter partitioin problem
*/
import java.util.ArrayList;

public class Solution 
{
    public static boolean check(ArrayList<Integer> arr, int mid, int k){
        int count = 1;
        int sum = 0;
        for(int e: arr){
            if(sum + e > mid){
                count++;
                sum = 0;
            }
            if(e > mid || count > k)
                return false;
            
            sum += e;
        }
        return true;
    }

    public static int painterPartition(ArrayList<Integer> boards, int s, int e, int k, int ans){
        if(s > e)
            return ans;
            
        int mid = s + (e-s)/2;    
        if(check(boards, mid, k)){
             ans = mid;
             e = mid -1;
        }
           
        
        else
            s = mid + 1;
        
        return painterPartition(boards, s, e, k, ans);
            
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
       int s = 0;
       int e = 0;
       for(int ele: boards){
           e += ele;
       }

       return painterPartition(boards, s, e, k, 0);
    }
}
