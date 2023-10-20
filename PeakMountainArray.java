/*
  TIME COMPLEXITY : O(logN)
  SPACE COMPLEXITY : O(1)
   mid can be on three position
        mid
         |
        / \
      mid  mid
      /     \
    /        \
*/
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int n = arr.length;
       int s = 0, e = n;

       while(s < e){
           int mid = s + (e-s)/2;
           if(mid < n - 1 && arr[mid] < arr[mid +1])
               s = mid + 1;
           
           else 
                e = mid;
       }

       return s;
    }
}
