package assignments2;

public class Problem3MergeSort {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 5, 7,9 };
		int[] arr2 = new int[] { 3,6, 10, 11 };
		int x = arr1.length;
		int y = arr2.length;
		int[] mergeArr = new int[x + y];
		mergeArr = mergeArr(arr1, arr2);
		for (int i : mergeArr) {
			System.out.println(i);
		}
	}

	public static int[] mergeArr(int[] arr1, int[] arr2) {
		int x = arr1.length;
		int y = arr2.length;
		int[] result = new int[x + y];
		int i = 0, j = 0;
		int index = 0;
		while (i < x && j < y) {
			if (arr1[i] < arr2[j]) {
				result[index++] = arr1[i];
				i++;
			} else {
				result[index++] = arr2[j];
				j++;
			}
		}
		while (i < x) {
			result[index++] = arr1[i];
			i++;
		}
		while (j < y) {
			result[index++] = arr2[j];
			j++;
		}
		return result;

	}

}
