package lab2B;

public class MySort {

	public static void mySort(int[] arr) {
		int countZero=0, countOne=0, countTwo=0;
		
		for (int i=0; i<arr.length;i++) {
			if (arr[i]==0) countZero++;
			else if(arr[i]==1) countOne++;
			else countTwo++;
		}
			System.out.println(countZero+" "+ countOne+" "+ countTwo);
		
		for (int i=0;i<countZero;i++) {
				arr[i]=0;
				}
		for (int i=countZero;i<countZero+countOne;i++) {
			arr[i]=1;
			}
		for (int i=countZero+countOne;i<arr.length;i++) {
			arr[i]=2;
			}
	
	
	}
	public static void main(String[] args) {
		int [] array= {1,1,1,0,0,0,2,2,2,1,0,0,0,2,2,2};
		mySort(array);
		for (int i=0;i<array.length;i++)
		{
		System.out.print(array[i]+" ");
		}
	}

}
