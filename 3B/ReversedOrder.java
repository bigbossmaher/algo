package lab3B;

public class ReversedOrder {

	static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }
	public static void main(String[] args) {
		int arr[]= {7,6,5,4,3,2,1};
		rvereseArray(arr,0,arr.length-1);
		
		for (int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
