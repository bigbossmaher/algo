package sortroutines;

import runtime.Sorter;

public class BubbleSort extends Sorter{

	int[] arr;
	@Override
	public int[] sort(int[] arr) {
		this.arr=arr;
		
		int len=arr.length;
		for (int i=0;i<len; ++i) {
			for (int j=0;j<len-1;++j) {
				
				if (arr[j]>arr[j+1]) {
					swap(j,j+1);
				}
			}
		}
		
		return arr;
	}
	 void swap(int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
 
}
