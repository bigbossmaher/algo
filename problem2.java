
public class problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int secondSmallest(int[] arr) {
		if(arr==null || arr.length < 2) {
		throw new IllegalArgumentException("Input array too small");
		}
		
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
		    if (arr[i] < smallest) {
		        secondSmallest = smallest;
		        smallest = arr[i];
		    } else if (arr[i] < secondSmallest) {
		        secondSmallest = arr[i];
		    }
		}
		return secondSmallest;
		}

}
