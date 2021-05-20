
public class problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5 ,6 , 10 , 1 , 3};
		int[] arrSorted = {5 ,7 , 9 , 11 , 13};

		System.out.println(searchCircularArray(arrSorted,11));
	}
	
	public static boolean find(int[] arr, int z) {
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i);
			if (arr[i] == z) return true;
		}
		return false;
	}
	
public static int  findinSorted(int[] arr, int z) {
		
	int left = 0 ;
	int right = arr.length;
	while (left<= right) {
		int middle = (left + right ) /2 ;
		if (arr[middle] == z ) return middle;
		if(arr[middle] > z) right = middle-1;
		else left = middle + 1 ;
		
		
		
	}
	return -1;
		
	}

public static int searchCircularArray(int[] A, int x)
{
    // search space is `A[left…right]`
    int left = 0;
    int right = A.length - 1;

    // loop till the search space is exhausted
    while (left <= right)
    {
        // find the mid-value in the search space and
        // compares it with the target
        int mid = (left + right) / 2;

        // if the key is found, return its index
        if (x == A[mid]) {
            return mid;
        }

        // if right half `A[mid…right]` is sorted and `mid` is not
        // the key element
        if (A[mid] <= A[right])
        {
            // compare key with `A[mid]` and `A[right]` to know
            // if it lies in `A[mid…right]` or not
            if (x > A[mid] && x <= A[right])
            {
                // go searching in the right sorted half
                left = mid + 1;
            }
            else {
                right = mid - 1;        // go searching left
            }
        }

        // if left half `A[left…mid]` is sorted, and `mid` is not
        // the key element
        else {
            // compare key with `A[left]` and `A[mid]` to know
            // if it lies in `A[left…mid]` or not
            if (x >= A[left] && x < A[mid])
            {
                // go searching in the left sorted half
                right = mid - 1;
            }
            else {
                left = mid + 1;         // go searching right
            }
        }
    }

    // key not found or invalid input
    return -1;
}



	
	

}
