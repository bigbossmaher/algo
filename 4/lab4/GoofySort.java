package lab4;

import java.util.Arrays;
import java.util.Random;

public class GoofySort {
	
	static int [] goofySort(int [] arr) {
		
		Random rand = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			int randomIndexToSwap = rand.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
			
		}
		return arr;
	}

		public static void main(String[] args) {
			
			int[] array = { 2, 4, 5, 6, 7, 3, 1 };
			
			goofySort(array);
			
			System.out.println(Arrays.toString(array));
		}
	
	

}
