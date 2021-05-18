public class problem1 {

	public static void main(String[] args) {
		int[] arr = {1,4,2,3,5};
		System.out.println(sumFound(arr , 5));

	}
	
	public static boolean sumFound(int[] arr, int z) {
		if(arr==null || arr.length < 2) {
		return false;
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j = (i+1) ; j<arr.length;j++) {
				if((arr[i]+arr[j]==z)&&(arr[i]!=arr[j])) {
					System.out.println(arr[i] + " + " + arr[j] + " = " + (arr[j]+arr[i]) );
					return true;
				}
			}
		}
		
		return false;
		}


}
