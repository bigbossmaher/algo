package assignment1a;

public class Problem2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 12, 6, 4, 3, 6, 7 };
		System.out.println("Another Approach: " + secondSmallest2(arr));
		System.out.println("Brute force approach: " + secondSmallest(arr));
	}

	// from brute force
	public static int secondSmallest(int[] arr) {
		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Input array too small");
		}
		int firstSmallIndex = smallestIndex(arr);
		arr[firstSmallIndex] = Integer.MAX_VALUE;
		return arr[smallestIndex(arr)];
	}

	// another approach
	public static int secondSmallest2(int[] arr) {
		if (arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Input array too small");
		}
		int firstSmall = arr[0];
		int secondSmall = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < firstSmall) {
				secondSmall = firstSmall;
				firstSmall = arr[i];
			}
		}
		return secondSmall;
	}

	private static int smallestIndex(int[] arr) {
		int minValue = arr[0];
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minValue) {
				minValue = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
