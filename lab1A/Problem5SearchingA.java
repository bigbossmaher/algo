package assignment1a;

public class Problem5SearchingA {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 15, 58, 9, 100 };
		int searhNum = 5;
		System.out.println(find(arr, searhNum));

	}

	public static boolean find(int[] arr, int z) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException("Empty array List");
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] == z)
				return true;
		}
		return false;
	}

}
