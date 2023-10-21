/*
  We use binary serach to find SQRT of a function
*/
import java.util.*;
import java.io.*;

public class Solution {

	public static int sqrtN(long N) {
		if (N == 0 || N == 1) {
			return (int) N;
		}

		long left = 1;
		long right = N;
		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (mid * mid == N) {
				return (int) mid;
			}

			if (mid * mid < N) {
				left = mid + 1;
				result = mid;
			} else {
				right = mid - 1;
			}
		}

		return (int) result;
	}
}
