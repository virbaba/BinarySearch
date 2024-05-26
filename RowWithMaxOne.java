import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int maxOne = Integer.MIN_VALUE;
        int maxOneRow = Integer.MIN_VALUE;

        int count = 0;
        for (ArrayList<Integer> list : mat) {
            int s = 0, e = m - 1;
            int ans = -1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if(list.get(mid) == 1){
                    ans = mid;
                    e = mid - 1;
                }else
                    s = mid + 1;
            }
            if(ans != -1){
                int newMaxOne = m - ans + 1;
                if(maxOne < newMaxOne){
                    maxOne = newMaxOne;
                    maxOneRow = count;
                }
            }
            count++;
        }

        return maxOneRow;
    }
}
