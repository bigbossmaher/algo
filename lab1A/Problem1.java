package assignment1a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1 {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 7, 1,3 };
		System.out.println(sumFound2(arr, 4));
	}

	// first approach - n^2 time method
	public static boolean sumFound(int[] arr, int z) {
		if (arr == null || arr.length < 2) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] != arr[j] && arr[i] + arr[j] == z)
					return true;
			}
		}
		return false;
	}

	// second approach - n time  using HashMap
	public static boolean sumFound2(int[] arr, int z) {
		if (arr == null || arr.length < 2) {
			return false;
		}
		Set<Integer> hashSet = new HashSet<Integer>();
		for (int num : arr) {
			hashSet.add(num);
		}
		for(Integer val : hashSet) {
			int complement = z - val;
			if(complement!= val && hashSet.contains(complement))
				return true;
		}
		return false;
	}

}
