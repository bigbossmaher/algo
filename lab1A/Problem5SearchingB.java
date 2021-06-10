package assignment1a;

public class Problem5SearchingB {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 8, 19, 100, 101 };
		int searchNum = 19;
		System.out.println(find(arr, searchNum));
	}

	// Binary Search Approach
	public static boolean find(int[] arr, int z) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException("Empty array List");
		int len = arr.length;
		int left = 0;
		int right = len;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (z == arr[mid])
				return true;
			else if (z < arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
	
	   // Binary Search Approach Recursive
		public static boolean find2(int[] arr, int z) {
			if (arr == null || arr.length == 0)
				throw new IllegalArgumentException("Empty array List");
			int len = arr.length;
			int left = 0;
			int right = len;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (z == arr[mid])
					return true;
				else if (z < arr[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			return false;
		}
}
